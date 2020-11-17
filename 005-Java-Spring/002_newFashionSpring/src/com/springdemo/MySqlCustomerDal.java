package com.springdemo;

public class MySqlCustomerDal implements ICustomerDal {
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