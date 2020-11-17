package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // replaces xml configuration to class class configuration
@ComponentScan("com.springdemo") // replaces context:component-scan
public class IocConfig {
	@Bean // Bean definition
	public ICustomerDal database() {
		return new OracleCustomerDal();
	}
}
