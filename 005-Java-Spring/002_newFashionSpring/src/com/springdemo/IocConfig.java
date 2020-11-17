package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // replaces xml configuration to class class configuration
@ComponentScan("com.springdemo") // replaces context:component-scan
@PropertySource("classpath:values.properties") // replaces context:property-placeholder or properties file usage
public class IocConfig {
	@Bean // Bean definition
	public ICustomerDal database() {
		return new MySqlCustomerDal();
	}

	@Bean // Bean definition
	public ICustomerService service() {
		// dependency injection in class config
		return new CustomerManager(database());
	}
}
