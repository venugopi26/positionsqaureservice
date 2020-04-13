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
@Table(name = "PROJECT")
public class Project implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1755085857425026042L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CLIENT_ID")
	private int clientId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CURRENT_STATE")
	private String state;
	
	@Column(name = "ESTIMATED_PROJECT_START")
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedStart;
	
	@Column(name = "ESTIMATED_PROJECT_END")
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedEnd;
	
	
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getEstimatedStart() {
		return estimatedStart;
	}

	public void setEstimatedStart(Date estimatedStart) {
		this.estimatedStart = estimatedStart;
	}

	public Date getEstimatedEnd() {
		return estimatedEnd;
	}

	public void setEstimatedEnd(Date estimatedEnd) {
		this.estimatedEnd = estimatedEnd;
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

	@Override
	public String toString() {
		return "Project [id=" + id + ", clientId=" + clientId + ", name=" + name + ", description=" + description
				+ ", state=" + state + ", estimatedStart=" + estimatedStart + ", estimatedEnd=" + estimatedEnd
				+ ", createdBy=" + createdBy + ", createdTs=" + createdTs + ", updatedBy=" + updatedBy + ", updatedTs="
				+ updatedTs + "]";
	}

	


}
