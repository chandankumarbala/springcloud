package com.poc.beans;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "maridbprops")
@JsonPropertyOrder({ "connectionUrl", "userName","password" })
public class CloudConfigBean {
	
	String dbUrl,dbUsername,dbAssertion;

	@JsonGetter("connectionUrl")
	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	@JsonGetter("userName")
	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	@JsonGetter("password")
	public String getDbAssertion() {
		return dbAssertion;
	}

	public void setDbAssertion(String dbAssertion) {
		this.dbAssertion = dbAssertion;
	}
}
