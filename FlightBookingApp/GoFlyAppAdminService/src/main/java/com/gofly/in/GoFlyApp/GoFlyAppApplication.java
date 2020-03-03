package com.gofly.in.GoFlyApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GoFlyAppApplication {
private static final Logger log=LoggerFactory.getLogger(GoFlyAppApplication.class); 
	public static void main(String[] args) 
	{
		log.info("####"+" "+"GoFlyAdmin"+" "+"#####");
		System.out.println("Welcome Admin");
		SpringApplication.run(GoFlyAppApplication.class, args);
	}

}
 