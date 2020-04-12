package com.position.positionSquareService.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author anush
 *
 */
@Entity
@Table(name = "TASK_DEPENDENCY")
public class TaskDependency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876617315855293041L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TASK_CURRENT_ID")
	private int taskCurrentId;
	
	@Column(name = "TASK_DEPENDENT_ID")
	private int taskDependentid;
	
	@Column(name = "TASK_PROIRITY")
	private int taskProirity;
	
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "UPDATED_TS" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskCurrentId() {
		return taskCurrentId;
	}

	public void setTaskCurrentId(int taskCurrentId) {
		this.taskCurrentId = taskCurrentId;
	}

	public int getTaskDependentid() {
		return taskDependentid;
	}

	public void setTaskDependentid(int taskDependentid) {
		this.taskDependentid = taskDependentid;
	}

	public int getTaskProirity() {
		return taskProirity;
	}

	public void setTaskProirity(int taskProirity) {
		this.taskProirity = taskProirity;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	
	

}
