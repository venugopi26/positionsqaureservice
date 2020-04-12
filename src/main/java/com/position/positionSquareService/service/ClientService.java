/**
 * 
 */
package com.position.positionSquareService.service;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.model.Project;
import com.position.positionSquareService.model.TaskDependency;
import com.position.positionSquareService.model.Tasks;
import com.position.positionSquareService.repository.ProjectRepository;
import com.position.positionSquareService.repository.TasksDependencyRepository;
import com.position.positionSquareService.repository.TasksRepository;

/**
 * @author anush
 *
 */
@Service
public class ClientService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	TasksRepository tasksRepository;

	@Autowired
	TasksDependencyRepository tasksDependencyRepository;

	@Transactional
	public ResponseEntity<Project> addProject(@Valid Project project, int clientId) {
		ResponseEntity<Project> response = new ResponseEntity<>();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setErrorResponse("Error in creating project !! please try again ");
		}
		return response;
	}

	@Transactional
	public ResponseEntity<Tasks> addTask(@Valid Tasks task, @Valid int projectId, int clientId) {
		ResponseEntity<Tasks> response = new ResponseEntity<>();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setErrorResponse("Error in creating Task !! please try again ");
		}
		return response;
	}

	@Transactional
	public ResponseEntity<Tasks> updateTask(@Valid Tasks task, @Valid int taskId, int clientId, @Valid int projectId) {
		Tasks oldTask = tasksRepository.getOne(taskId);
		long startNo = task.getTaskEnd().getTime() - oldTask.getTaskEnd().getTime();

		Set<TaskDependency> tasks = tasksDependencyRepository.getDependentTaskTaskByProject(taskId);
		System.out.println("tasks:" + tasks.size());
		tasks.forEach((taskDepend) -> {
			task.setProjectId(projectId);
			tasksRepository.save(task);
			Tasks dependentTask = tasksRepository.getOne(taskDepend.getTaskDependentid());
			long endNo = dependentTask.getTaskEnd().getTime() - dependentTask.getTaskStart().getTime();
			dependentTask.setTaskStart(new Date(task.getTaskEnd().getTime() + startNo));
			dependentTask.setTaskEnd(new Date(dependentTask.getTaskEnd().getTime() + startNo));
			tasksRepository.save(dependentTask);
		});

		ResponseEntity<Tasks> response = new ResponseEntity<>();
		response.setStatusCode(200);
		return response;
	}

	@Transactional
	public ResponseEntity<Tasks> addTaskDependencies(int clientId, @Valid TaskDependency dt) {
		ResponseEntity<Tasks> response = new ResponseEntity<>();
		response.setStatusCode(500);
		try {
			TaskDependency taskDependency = tasksDependencyRepository.addTaskDependency(dt.getTaskCurrentId(),
					dt.getTaskDependentid());
			if (null == taskDependency) {
				tasksDependencyRepository.save(dt);
				response.setStatusCode(200);
			} else {
				response.setErrorResponse("Already exists");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setErrorResponse("Error in creating Task !! please try again ");
		}
		return response;
	}

}
