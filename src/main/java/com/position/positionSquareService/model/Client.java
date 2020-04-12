package com.position.positionSquareService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author anush
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable{

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String clientName, String pan, String website, Boolean isInternal, String createdBy,
			Date createdTs, String updatedBy, Date updatedTs, Set<User> users) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.pan = pan;
		this.website = website;
		this.isInternal = isInternal;
		this.createdBy = createdBy;
		this.createdTs = createdTs;
		this.updatedBy = updatedBy;
		this.updatedTs = updatedTs;
		this.users = users;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1588580154761069023L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CLIENT_NAME")
	private String clientName;
	
	@Column(name = "PAN")
	private String pan;
	
	@Column(name = "WEBSITE")
	private String website;
	
	@Column(name = "IS_INTERNAL")
	private Boolean isInternal;
	
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
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    private Set<User> users ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Boolean getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + ", pan=" + pan + ", website=" + website
				+ ", isInternal=" + isInternal + ", createdBy=" + createdBy + ", createdTs=" + createdTs
				+ ", updatedBy=" + updatedBy + ", updatedTs=" + updatedTs + ", users=" + users + "]";
	}

	
}
