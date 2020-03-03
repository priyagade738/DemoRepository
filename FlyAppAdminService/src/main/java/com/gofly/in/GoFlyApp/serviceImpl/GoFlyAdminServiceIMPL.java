package com.gofly.in.GoFlyApp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gofly.in.GoFlyApp.repository.GoFlyAdminRepository;
import com.gofly.in.GoFlyApp.serviceI.GoFlyAdminServiceI;

public class GoFlyAdminServiceIMPL implements GoFlyAdminServiceI
{

	@Autowired
	GoFlyAdminRepository r;
	
	
	
	
}
