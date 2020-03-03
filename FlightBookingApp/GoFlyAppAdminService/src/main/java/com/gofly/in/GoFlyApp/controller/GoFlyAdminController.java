package com.gofly.in.GoFlyApp.controller;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.PastOrPresent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gofly.in.GoFlyApp.Entity.GoFlyAdminEntity;
import com.gofly.in.GoFlyApp.model.GoFlyAdminFlightReschedule;
import com.gofly.in.GoFlyApp.serviceI.GoFlyAdminServiceI;

@RequestMapping("/Admin-service")
@RestController
public class GoFlyAdminController
{
	private static final Logger log=LoggerFactory.getLogger(GoFlyAdminController.class);
	
  @Autowired
  GoFlyAdminServiceI s;

//@RequestMapping(value="POST")
@PostMapping(value="add/flight")
private ResponseEntity<String> addNewFlight(@Valid @RequestBody GoFlyAdminEntity flight)
{
	//Without logger
	//String responce=s.addFlight(flight);
	//return new ResponseEntity<>(responce,HttpStatus.CREATED); 

	String responce="Invalid flight!";
    HttpStatus status=HttpStatus.BAD_REQUEST;
    log.info("Success");
    if(flight!=null)
    {
    	responce=s.addFlight(flight);
    	status=HttpStatus.CREATED;
    }
	return new ResponseEntity<String>(responce,status);
	
}
	@PostMapping("/flights.add")
	private ResponseEntity<String> addflights(@Valid @RequestBody List<GoFlyAdminEntity> flights)
	{
		String resMessage=s.addFlights(flights);
		return new ResponseEntity<String>(resMessage,HttpStatus.CREATED);
	}
	
	@GetMapping("/flights/{flightId}")
	private ResponseEntity<Object> getFlight(@PathVariable String flightId)
	{
		GoFlyAdminEntity flight=s.getFlight(flightId);
		if(flight !=null)
		{
			return new ResponseEntity<Object>(flight,HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Flight:"+flightId+"dones not exixt !!",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/flight/update")
	private ResponseEntity<Object> updateFlight(@Valid @RequestBody GoFlyAdminEntity flightToUpdate)
	{
		GoFlyAdminEntity flight=s.updateFlight(flightToUpdate);
		if(flight !=null)
		{
			return new ResponseEntity<Object>(flight,HttpStatus.OK);
		}
		return new ResponseEntity<Object>("FLight:"+flightToUpdate+"does not exit !!",HttpStatus.NOT_FOUND);
	}
	@PatchMapping("/flight/reschedule")
	private ResponseEntity<Object> rescheduleFlight(@RequestBody GoFlyAdminFlightReschedule flightPathch)
	{                                      
		GoFlyAdminEntity rescheduleFlight=s.RescheduleFlight(flightPathch);
		if(rescheduleFlight != null)
		{
			return new ResponseEntity<Object>(rescheduleFlight, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Flight: "+flightPathch.getFlightId()+" does not exist!!", HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/flights")
	private ResponseEntity<List<GoFlyAdminEntity>> getAllFlight()
	{
		List<GoFlyAdminEntity> flights=s.getAllFlights();
		return new ResponseEntity<List<GoFlyAdminEntity>>(flights,HttpStatus.OK);
	}
	
	@DeleteMapping("/flight/remove/{flightId}")
	private ResponseEntity<String> deleteFlight(@PathVariable String flightId)
	{
		String resMessage=s.DeleteFlight(flightId);
		if(resMessage != null)
		{
			return new ResponseEntity<String>(resMessage, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Flight: "+flightId+" does not exist!!", HttpStatus.NOT_FOUND);
	
	}
}

