package com.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // replaces xml file with this class
@ComponentScan("com.springdemo") // replaces context:component-scan
public class IocConfig {

}
