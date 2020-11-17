package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

// import org.springframework.stereotype.Component;

// Annotation
//@Component("database")
public class OracleCustomerDal implements ICustomerDal {
	@Value("${database.oracleConnectionString}") // property injection 
	String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public void add() {
		System.out.println("Oracle connection string-> " + connectionString);
		System.out.println("Oracle Database Added!");

	}

}
