package com.position.positionSquareService.mapper;

import java.util.List;
import java.util.Map;

import com.position.positionSquareService.model.TaskDependency;

public interface ClientMapper {

//	List<Map<Object, Object>> getClients(int clientId ,int userId);
	
	List<Map<Object, Object>> getProjects(int clientId ,int userId);
	
	List<Map<Object, Object>> getTasks(int clientId ,int projectId ,int userId);

	List<Map<Object, Object>> addDependentTasks(int clientId, TaskDependency dt);
}
