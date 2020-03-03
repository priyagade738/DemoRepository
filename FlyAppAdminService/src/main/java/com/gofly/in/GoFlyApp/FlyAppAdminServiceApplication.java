package com.gofly.in.GoFlyApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FlyAppAdminServiceApplication
{

	private static final Logger Log=LoggerFactory.getLogger(FlyAppAdminServiceApplication.class);
	public static void main(String[] args) 
	{
		Log.info("####"+""+"GoFlyAdmin"+""+""+"");
		System.out.println("Welcome Admin");
		SpringApplication.run(FlyAppAdminServiceApplication.class, args);
		
	}

}
