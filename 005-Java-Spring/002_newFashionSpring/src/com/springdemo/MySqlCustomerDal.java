package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class MySqlCustomerDal implements ICustomerDal {
	@Value("${database.mysqlConnectionString}") // property injection 
	String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public void add() {
		System.out.println("MySql connection string-> " + connectionString);
		System.out.println("MySql Database Added.");

	}

}
