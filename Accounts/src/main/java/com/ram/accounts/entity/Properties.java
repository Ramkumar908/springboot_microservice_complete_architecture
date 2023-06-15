package com.ram.accounts.entity;

import java.util.List;
import java.util.Map;

public class Properties {

	private String msg;
	private String buildVersion;
	private Map<String,String> mailDetails;
	private List<String> activeBrances;
	
	public Properties() {
	
		// TODO Auto-generated constructor stub
	}
	public Properties(String msg, String buildVersion, Map<String, String> mailDetails, List<String> activeBrances) {
		
		this.msg = msg;
		this.buildVersion = buildVersion;
		this.mailDetails = mailDetails;
		this.activeBrances = activeBrances;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getBuildVersion() {
		return buildVersion;
	}
	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}
	public Map<String, String> getMailDetails() {
		return mailDetails;
	}
	public void setMailDetails(Map<String, String> mailDetails) {
		this.mailDetails = mailDetails;
	}
	public List<String> getActiveBrances() {
		return activeBrances;
	}
	public void setActiveBrances(List<String> activeBrances) {
		this.activeBrances = activeBrances;
	}
	@Override
	public String toString() {
		return "Properties [msg=" + msg + ", buildVersion=" + buildVersion + ", mailDetails=" + mailDetails
				+ ", activeBrances=" + activeBrances + "]";
	}

	
}

