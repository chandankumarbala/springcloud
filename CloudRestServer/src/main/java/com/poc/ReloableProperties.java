package com.poc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="cloud.config")
@RefreshScope
public class ReloableProperties {
	String dbUrl,dbUsername,dbAssertion;

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbAssertion() {
		return dbAssertion;
	}

	public void setDbAssertion(String dbAssertion) {
		this.dbAssertion = dbAssertion;
	}
}
