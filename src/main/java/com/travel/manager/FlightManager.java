package com.travel.manager;

import com.travel.entity.Flight;
import com.travel.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightManager {

    @Autowired
    FlightRepository flightRepository;

    public void createFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }
}
