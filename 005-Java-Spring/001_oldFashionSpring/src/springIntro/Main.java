package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * IoC -> Inversion of Control Design
 * Desing Pattern -> Dependency Injection
 * IoC can managed by xml, class and annotations in Spring
 * 
 * See applicationContext.xml
 * */
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		CustomerManager customerManager = new CustomerManager(context.getBean("database", ICustomerDal.class));
		customerManager.add();	
		 */	
		
		ICustomerService customerService = context.getBean("service", ICustomerService.class);
		customerService.add();
		
	}
}
