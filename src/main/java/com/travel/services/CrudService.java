package com.travel.services;

import com.travel.entity.City;
import com.travel.entity.Flight;
import com.travel.manager.CityManager;
import com.travel.manager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    @Autowired
    CityManager cityManager;

    @Autowired
    FlightManager flightManager;

    public void createCity(String name){
        if(null==cityManager.findCityByName(name)){
            City city = new City();
            city.setName(name);
            cityManager.createCity(city);
        }
        else
            throw new RuntimeException("No city with the same name allowed.");
    }

    public void createFlight(String fromDestinationId, String toDestinationId){
        City fromDestination = cityManager.findCityByName(fromDestinationId);
        City toDestination = cityManager.findCityByName(toDestinationId);
        Flight flight = new Flight();
        flight.setFromDestination(fromDestination);
        flight.setToDestination(toDestination);
        flightManager.createFlight(flight);
    }
}
