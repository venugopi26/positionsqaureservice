/**
 * 
 */
package com.position.positionSquareService.service;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.model.Project;
import com.position.positionSquareService.model.TaskDependency;
import com.position.positionSquareService.model.Tasks;
import com.position.positionSquareService.repository.ProjectRepository;
import com.position.positionSquareService.repository.TasksDependencyRepository;
import com.position.positionSquareService.repository.TasksRepository;
import com.position.positionSquareService.utils.TaskValidation;

/**
 * @author anush
 *
 */
@Service
public class ClientService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	TasksRepository tasksRepository;

	@Autowired
	TasksDependencyRepository tasksDependencyRepository;
	
	@Autowired
	TaskValidation taskValidation;

	@Transactional
	public ResponseEntity<Project> addProject(@Valid Project project, int clientId) {
		ResponseEntity<Project> response = new ResponseEntity<Project>();
		response.setStatusCode(500);
		try {
			Project pro = projectRepository.getprojectByName(project.getName(), clientId);
			if (null == pro) {
				project.setClientId(clientId);
				projectRepository.save(project);
				response.setResponse(project);
				response.setStatusCode(200);
			} else {
				response.setErrorResponse("Already exists");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			response.setErrorResponse("Error in creating project !! please try again ");
		}
		return response;
	}

	@Transactional
	public ResponseEntity<Tasks> addTask(@Valid Tasks task, @Valid int projectId, int clientId) {
		ResponseEntity<Tasks> response = new ResponseEntity<Tasks>();
		response.setStatusCode(500);
		try {
			Tasks tasks = tasksRepository.getTaskByProject(task.getTaskName(), projectId, clientId);
			if (null == tasks) {
				task.setProjectId(projectId);
				tasksRepository.save(task);
				response.setResponse(task);
				response.setStatusCode(200);
			} else {
				response.setErrorResponse("Already exists");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			response.setErrorResponse("Error in creating Task !! please try again ");
		}
		return response;
	}

	@Transactional
	public ResponseEntity<Tasks> updateTask(@Valid Tasks task, @Valid int taskId, int clientId, @Valid int projectId) {
		ResponseEntity<Tasks> response= new ResponseEntity<Tasks>();
		response.setStatusCode(500);
		try {
			Tasks oldTask = tasksRepository.findOne(taskId);
			if(oldTask.getProgress()!=100) {
				long startNo = task.getTaskStart().getTime() - oldTask.getTaskStart().getTime();
				long endNo = task.getTaskEnd().getTime() - oldTask.getTaskEnd().getTime();
				// intial update for tasks 
				// check if progress is chaneged if chanegs then validate wheather the if linking is thr check if the taks has been completed 
				Tasks tk = taskValidation.validateTaskForUpdate(oldTask, task);
				tasksRepository.save(tk);
				
				Set<TaskDependency> tasks = tasksDependencyRepository.getDependentTaskTaskByProject(taskId);
				LOGGER.info("get task dependencies" + tasks.toString());
				if(tasks !=null) {
					tasks.forEach((taskDepend) -> {
						LOGGER.info("getlist task dependencies" +  taskDepend.toString());
						Tasks dependentTask = tasksRepository.findOne(taskDepend.getTaskCurrentId());
						LOGGER.info("find one " +  dependentTask.toString());
						LOGGER.info("startNo " + startNo);
						LOGGER.info("endNo " + endNo);
						dependentTask.setTaskStart(new Date(dependentTask.getTaskStart().getTime() + endNo));
						dependentTask.setTaskEnd(new Date(dependentTask.getTaskEnd().getTime() + endNo));
						tasksRepository.save(dependentTask);
						LOGGER.info("dependentTask " + dependentTask.toString());
					});	
				}
				response = new ResponseEntity<>();
				response.setStatusCode(200);
				response.setResponse(tk);
			}else {
				response.setErrorResponse("Task Completed cannot update!!");
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			response.setErrorResponse(e.getMessage());
		}
		return response;
	}

	@Transactional
	public ResponseEntity<TaskDependency> addTaskDependencies(int clientId, @Valid TaskDependency dt) {
		ResponseEntity<TaskDependency> response = new ResponseEntity<TaskDependency>();
		response.setStatusCode(500);
		try {
			TaskDependency taskDependency = tasksDependencyRepository.addTaskDependency(dt.getTaskCurrentId(),
					dt.getTaskDependentid());
			if (null == taskDependency) {
				tasksDependencyRepository.save(dt);
				// check validations 
				taskValidation.validateTaskDetails(dt);
				response.setResponse(dt);
				response.setStatusCode(200);
			} else {
				response.setErrorResponse("Already exists");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			response.setErrorResponse("Error in creating Task !! please try again ");
		}
		return response;
	}
}
