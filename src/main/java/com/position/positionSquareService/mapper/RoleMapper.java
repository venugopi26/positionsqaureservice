package com.position.positionSquareService.mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	
	List<Map<Object, Object>> getRoleMaster();

	List<Map<Object, Object>> getRoleForUser(int userId);

}
