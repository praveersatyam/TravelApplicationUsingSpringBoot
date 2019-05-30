package com.travel.controller;

import com.travel.entity.Tour;
import com.travel.services.PathFinderService;
import com.travel.util.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "tour", produces = MediaType.APPLICATION_JSON_VALUE)
public class TourController {

    @Autowired
    DataInitializer dataInitializer;

    @Autowired
    PathFinderService pathFinderService;

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity findPath(@RequestParam(value = "fromDestination") String fromDestination, @RequestParam(value = "toDestination") String toDestination) {
        Tour tour = dataInitializer.initializeTour();
        return new ResponseEntity(pathFinderService.findIndirectFlightPathByCityName(fromDestination, toDestination, tour), HttpStatus.OK);
    }
}
