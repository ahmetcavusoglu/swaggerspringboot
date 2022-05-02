package com.ahmetcavusoglu.swaggerspringboot.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCongfiguration {

	private ConfigProperties cfProp;

	public DatabaseCongfiguration(ConfigProperties cfProp) {
		this.cfProp = cfProp;
	}

	public Connection db() throws SQLException {

		String url = cfProp.getUrl();
		String user = cfProp.getUsername();
		String pass = cfProp.getPassword();

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("connection success");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
	}

//	@Bean
//    public Connection getDataSource() throws SQLServerException
//    {	

//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(cfProp.getDriverClassName());
//        dataSourceBuilder.url(cfProp.getUrl());
//        dataSourceBuilder.username(cfProp.getUsername());
//        dataSourceBuilder.password(cfProp.getPassword());
//        return dataSourceBuilder.build();

//		SQLServerDataSource dataSource = new SQLServerDataSource();
//	    dataSource.setUser(cfProp.getUsername());
//	    dataSource.setPassword(cfProp.getPassword());
//	    dataSource.setServerName(cfProp.getUrl());
//	    dataSource.setDatabaseName("test");
//	    dataSource.getConnection(cfProp.getUsername(),cfProp.getPassword());
//		return dataSource;

//	    return null;    
//    }

}
