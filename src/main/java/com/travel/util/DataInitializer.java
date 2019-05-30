package com.travel.util;

import com.travel.entity.Flight;
import com.travel.entity.Tour;
import com.travel.manager.CityManager;
import com.travel.manager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    FlightManager flightManager;

    @Autowired
    CityManager cityManager;

    public Tour initializeTour(){
        Tour tour = new Tour();
        tour.setAvailableFlights(initializeFlights());
        tour.setGraphOfFlights(initializeGraph(tour));
        return tour;
    }

    public List<Flight> initializeFlights(){
        return flightManager.findAllFlights();
    }

    public List<Integer>[] initializeGraph(Tour tour) {
        Integer size = cityManager.findMaxIndexOfCities();
        List<Integer>[] listImplementedGraph = new List[size + 1];
        initializeListArray(listImplementedGraph);
        for (Flight flight : tour.getAvailableFlights()) {
            listImplementedGraph[flight.getFromDestination().getId()].add(flight.getToDestination().getId());
            listImplementedGraph[flight.getToDestination().getId()].add(flight.getFromDestination().getId());
        }
        return listImplementedGraph;
    }

    private static void initializeListArray(List<Integer>[] listImplementedGraph) {
        for (int i = 0; i < listImplementedGraph.length; i++) {
            listImplementedGraph[i] = new ArrayList<>();
        }
    }
}
