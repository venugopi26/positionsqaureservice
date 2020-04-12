/**
 * 
 */
package com.position.positionSquareService.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.position.positionSquareService.dto.ResponseEntity;
import com.position.positionSquareService.mapper.ClientMapper;
import com.position.positionSquareService.model.Project;
import com.position.positionSquareService.model.TaskDependency;
import com.position.positionSquareService.model.Tasks;
import com.position.positionSquareService.model.User;
import com.position.positionSquareService.service.ClientService;
import com.position.positionSquareService.service.UserService;

/**
 * @author anush
 *
 */
@RestController
@RequestMapping("/clientservice")
public class ClientController {

	@Autowired
	UserService userService;

	@Autowired
	ClientService clientService;

	@Autowired
	private ClientMapper clientMapper;

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestHeader(value = "clientId") int clientId,
			@Valid @RequestBody User user) {
		return userService.createUser(user, clientId);
	}

	@PostMapping("/addproject")
	public ResponseEntity<Project> addProject(@RequestHeader(value = "clientId") int clientId,
			@Valid @RequestBody Project project) {
		return clientService.addProject(project, clientId);
	}

	@PostMapping("/addTask")
	public ResponseEntity<Tasks> addTask(@RequestHeader(value = "clientId") int clientId,
			@Valid @RequestHeader(value = "projectId") int projectId, @Valid @RequestBody Tasks task) {
		return clientService.addTask(task, projectId, clientId);
	}

	@PutMapping("/updateTask")
	public ResponseEntity<Tasks> updateTask(@RequestHeader(value = "clientId") int clientId,
			@Valid @RequestHeader(value = "taskId") int taskId,@Valid @RequestHeader(value = "projectId") int projectId, @Valid @RequestBody Tasks task) {
		return clientService.updateTask(task, taskId, clientId,projectId);
	}

	@GetMapping("/projects")
	public ResponseEntity<List<Map<Object, Object>>> getProjects(@RequestHeader(value = "clientId") int clientId,
			@RequestHeader(value = "userId") int userId) {
		ResponseEntity<List<Map<Object, Object>>> response = new ResponseEntity<List<Map<Object, Object>>>();
		response.setResponse(clientMapper.getProjects(clientId, userId));
		response.setStatusCode(200);
		return response;
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<Map<Object, Object>>> getTasks(@RequestHeader(value = "clientId") int clientId,
			@RequestHeader(value = "projectId") int projectId, @RequestHeader(value = "userId") int userId) {
		ResponseEntity<List<Map<Object, Object>>> response = new ResponseEntity<List<Map<Object, Object>>>();
		response.setResponse(clientMapper.getTasks(clientId, projectId, userId));
		response.setStatusCode(200);
		return response;
	}

	@PostMapping("/addTaskDependencies")
	public ResponseEntity<Tasks> updateTaskDependencies(@RequestHeader(value = "clientId") int clientId,
			@RequestBody TaskDependency dt) {
		return clientService.addTaskDependencies(clientId, dt);
	}

}
