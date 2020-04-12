package com.position.positionSquareService.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	Map<Object, Object> getUserById(int userId);
	
	List<Map<Object, Object>> getUsers(int clientId);
	
}
