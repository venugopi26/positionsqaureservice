package com.position.positionSquareService.model;


import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "CLICK_ID")
	private String clickId;
	
	@Column(name = "KEYWORD_ID")
	private String keywordId;
	
	@Column(name = "CAMPAIGN_ID")
	private String campaignId;				

	public String getClickId() {
		return clickId;
	}

	public void setClickId(String clickId) {
		this.clickId = clickId;
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
		return "GoogleClicks [clickId=" + clickId + ", keywordId=" + keywordId + ", campaignId=" + campaignId + "]";
	}
	
}
