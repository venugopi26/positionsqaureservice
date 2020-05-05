package com.position.positionSquareService.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author venu
 *
 */
@Entity
@Table(name = "GOOGLE_CLICKS")
public class GoogleClicks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "GCL_ID")
	private String gclId;
	
	@Column(name = "KEYWORD_ID")
	private String keywordId;
	
	@Column(name = "CAMPAIGN_ID")
	private String campaignId;					

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getGclId() {
		return gclId;
	}

	public void setGclId(String gclId) {
		this.gclId = gclId;
	}

	public String getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(String keywordId) {
		this.keywordId = keywordId;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	@Override
	public String toString() {
		return "GoogleClicks [Id=" + Id + ", gclId=" + gclId + ", keywordId=" + keywordId + ", campaignId=" + campaignId
				+ "]";
	}			
}
