package com.ahmetcavusoglu.swaggerspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ConfigProperties {

	private String url; // spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=test
	private String username;// spring.datasource.username=sa
	private String password;// spring.datasource.password=ahmet1
	private String driverClassName; // spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	
}
