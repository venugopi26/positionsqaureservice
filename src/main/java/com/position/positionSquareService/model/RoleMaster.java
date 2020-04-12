/**
 * 
 */
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
@Table(name = "ROLE_MASTER")
public class RoleMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -765612392402623004L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CREATED_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;
	
	@Column(name = "ROLE_NAME")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
	

}
