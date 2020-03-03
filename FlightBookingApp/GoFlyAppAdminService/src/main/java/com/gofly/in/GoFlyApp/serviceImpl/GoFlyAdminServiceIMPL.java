package com.gofly.in.GoFlyApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.FkSecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofly.in.GoFlyApp.Entity.GoFlyAdminEntity;
import com.gofly.in.GoFlyApp.model.GoFlyAdminFlightReschedule;
import com.gofly.in.GoFlyApp.repository.GoFlyAdminRepository;
import com.gofly.in.GoFlyApp.serviceI.GoFlyAdminServiceI;
@Service
public class GoFlyAdminServiceIMPL implements GoFlyAdminServiceI {
@Autowired
GoFlyAdminRepository r;
	
	
	@Override
	public String addFlights(List<GoFlyAdminEntity> flights)
	{
	r.saveAll(flights);	
		return "flights:"+flights.iterator()+"added succesfully";
	}

	@Override
	public String addFlight(GoFlyAdminEntity flight) {
		r.save(flight);
		return "flight:"+flight.getFlightId()+" "+"added Succesfully";
	}

	@Override
	public GoFlyAdminEntity getFlight(String flightId) 
	{
		Optional<GoFlyAdminEntity> optionalflight=r.findById(flightId);
		if(optionalflight.isPresent())
		{	
		return optionalflight.get();	
		}
		return null;
	}

	@Override
	public GoFlyAdminEntity updateFlight(GoFlyAdminEntity flightToUpdade)
	{
		Optional<GoFlyAdminEntity> optionalflight=r.findById(flightToUpdade.getFlightId());
		if(optionalflight.isPresent())
		{
			r.save(flightToUpdade);
			return flightToUpdade;
		}
		return null;
	
	}

	@Override
	public GoFlyAdminEntity RescheduleFlight(GoFlyAdminFlightReschedule flightToReschedule) 
	{
		Optional<GoFlyAdminEntity> optionalflight=r.findById(flightToReschedule.getFlightId());
		if(optionalflight.isPresent())
		{
			GoFlyAdminEntity flight=optionalflight.get();
			flight.setFlightDepartureDate(flightToReschedule.getFlightArrivalDate());
			flight.setFlightArrivalDate(flightToReschedule.getFlightArrivalDate());
			flight.setFlightArrivalTime(flightToReschedule.getFlightArrivalTime());
             flight.setFlightDepartureTime(flightToReschedule.getFlightDepartureTime());			
			r.save(flight);
			return flight;
		}
		return null;
	}

	
	@Override
	public String DeleteFlight(String flightId) 
	{
    Optional<GoFlyAdminEntity> optionalflight=r.findById(flightId);
    if(optionalflight.isPresent())
    {
    	r.deleteById(flightId);
    	return "Flight:"+flightId+"remover from records !!";
    	
    }
		return null;
	}

	@Override
	public List<GoFlyAdminEntity> getAllFlights()
	{
		return (List<GoFlyAdminEntity> )r.findAll();
	}

}
