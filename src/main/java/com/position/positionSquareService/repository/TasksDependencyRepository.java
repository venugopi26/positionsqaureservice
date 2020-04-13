package com.position.positionSquareService.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.position.positionSquareService.model.TaskDependency;

@Repository
public interface TasksDependencyRepository extends JpaRepository<TaskDependency, Long> {

	@Query("select t from TaskDependency t where t.taskDependentid = ?1")
	Set<TaskDependency> getDependentTaskTaskByProject(int taskCurrentID);

	@Query("select t from TaskDependency t where t.taskCurrentId = ?1 and t.taskDependentid = ?2")
	TaskDependency addTaskDependency(int currentTaskID, int dependentTaskID);

}
