package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * IoC with annotations
 * Annotations added above of a class and imported from spring
 * */
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
		customerDal.add();

	}
}
