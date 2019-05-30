package com.travel.services;

import com.travel.entity.City;
import com.travel.entity.Tour;
import com.travel.manager.CityManager;
import com.travel.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathFinderService {

    @Autowired
    CityManager cityManager;

    @Autowired
    ConvertUtil convertUtil;

    public String findIndirectFlightPathByCityName(String fromDestinationName, String toDestinationName, Tour tour){
        City fromDestination = cityManager.findCityByName(fromDestinationName);
        City toDestination = cityManager.findCityByName(toDestinationName);
        return findIndirectFlightPath(fromDestination, toDestination, tour);
    }

    public String findIndirectFlightPath(City fromDestination, City toDestination, Tour tour) {
        Integer fromDestinationId = fromDestination.getId();
        Integer toDestinationId = toDestination.getId();
        Integer size = cityManager.findMaxIndexOfCities();
        boolean[] isVisited = new boolean[size + 1];
        List<Integer> cityIdPathList =  findIndirectFlightPath(new ArrayList<>(),tour.getGraphOfFlights(), fromDestinationId, toDestinationId, isVisited);
        if(null != cityIdPathList && cityIdPathList.size()>0){
            List<City> cityList = cityManager.findCityListByIdList(cityIdPathList);
            return convertUtil.findPathByCityList(cityList);
        }
        return "false";
    }

    private List<Integer> findIndirectFlightPath(List<Integer> cityInThePathList, List<Integer>[] graphOfConnectedCities, Integer rootNode, Integer destinationNode, boolean[] isVisited) {
        if (rootNode == destinationNode) {
            cityInThePathList.add(rootNode);
            return cityInThePathList;
        } else {
            return addPathForNotVisitedConnectedCities(cityInThePathList, graphOfConnectedCities, rootNode, destinationNode, isVisited);
        }
    }

    private List<Integer> addPathForNotVisitedConnectedCities(List<Integer> cityInThePathList, List<Integer>[] graphOfConnectedCities, Integer rootNode, Integer destinationNode, boolean[] isVisited) {
        isVisited[rootNode] = true;
        cityInThePathList.add(rootNode);
        for (Integer cityId : graphOfConnectedCities[rootNode]) {
            if (!isVisited[cityId]) {
                return findIndirectFlightPath(cityInThePathList, graphOfConnectedCities, cityId, destinationNode, isVisited);
            }
        }
        return null;
    }
}
