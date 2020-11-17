package com.springdemo;

public class CustomerManager implements ICustomerService {
	// Dependency injection design pattern
	private ICustomerDal customerDal;

	// Constructor injection
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public void add() {
		// Business rules
		customerDal.add();
	}
}
