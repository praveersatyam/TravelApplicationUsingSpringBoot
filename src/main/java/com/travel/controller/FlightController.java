package com.travel.controller;

import com.travel.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "flight", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {

    @Autowired
    CrudService crudService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createFlight(@RequestParam(value = "fromDestination") String fromDestination, @RequestParam(value = "toDestination") String toDestination){
        crudService.createFlight(fromDestination,toDestination);
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
