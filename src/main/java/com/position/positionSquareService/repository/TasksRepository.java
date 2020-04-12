/**
 * 
 */
package com.position.positionSquareService.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.Tasks;

/**
 * @author anush
 *
 */
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer>{

	@Query("select t from Tasks t where t.taskName = ?1 and t.projectId = ?2")
	Tasks getTaskByProject(String taskName, @Valid int projectId, int clientId);

}

