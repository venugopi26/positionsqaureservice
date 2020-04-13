package com.position.positionSquareService.utils;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.position.positionSquareService.model.Tasks;
import com.position.positionSquareService.repository.TasksRepository;

public class TaskValidation {
	
	@Autowired
	TasksRepository tasksRepository;
	
	public Tasks validateTaskForUpdate(Tasks oldTask, @Valid Tasks task) throws Exception {
		if(oldTask.getProgress()!= task.getProgress()) {
			// check if thr is any previous dependent task 
			Set<Tasks> previousProgress = tasksRepository.getTaskDetials(task.getId());
			if(previousProgress!=null) {
				for(Tasks tk : previousProgress) {
					if(tk.getProgress()!=100) {
						throw new Exception("Previous tasks has not been completed");
					}
				}
			}
		}
		oldTask.setTaskDescription(task.getTaskDescription());
		oldTask.setProgress(task.getProgress());
		oldTask.setTaskEnd(task.getTaskEnd());
		oldTask.setTaskStart(task.getTaskStart());
		if(task.getProgress()==100) {
			oldTask.setTaskStatus("COMPLETED");
		}
		return oldTask;
	}

}
