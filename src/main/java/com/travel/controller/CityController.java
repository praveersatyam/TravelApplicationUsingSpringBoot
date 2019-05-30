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
@RequestMapping(value = "city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    @Autowired
    CrudService crudService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createCity(@RequestParam(value = "name") String name){
        crudService.createCity(name);
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
