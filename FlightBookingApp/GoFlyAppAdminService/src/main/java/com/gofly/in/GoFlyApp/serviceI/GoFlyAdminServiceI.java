package com.gofly.in.GoFlyApp.serviceI;

import java.util.List;

import com.gofly.in.GoFlyApp.Entity.GoFlyAdminEntity;
import com.gofly.in.GoFlyApp.model.GoFlyAdminFlightReschedule;

public interface GoFlyAdminServiceI 
{
public String addFlights(List<GoFlyAdminEntity> flights);
public String addFlight(GoFlyAdminEntity flight);
public GoFlyAdminEntity getFlight(String flightId);
public GoFlyAdminEntity updateFlight(GoFlyAdminEntity flightToUpdade);
public GoFlyAdminEntity RescheduleFlight(GoFlyAdminFlightReschedule flightToReschedule);
public String DeleteFlight(String flightId);	
public List<GoFlyAdminEntity> getAllFlights() ;	
	
}
