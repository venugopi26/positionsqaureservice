/**
 * 
 */
package com.position.positionSquareService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.Project;

/**
 * @author anush
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query("select p from Project p where p.name = ?1 and p.clientId = ?2")
	Project getprojectByName(String name, int clientId);

}

