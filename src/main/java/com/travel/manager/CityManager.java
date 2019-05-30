package com.travel.manager;

import com.travel.entity.City;
import com.travel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityManager {

    @Autowired
    CityRepository cityRepository;

    public void createCity(City city){
        cityRepository.save(city);
    }

    public City findById(Integer id){
        return cityRepository.findById(id).get();
    }

    public City findCityByName(String name){
        List<City> cityList = cityRepository.findAllByName(name);
        if(!CollectionUtils.isEmpty(cityList)){
            return cityList.get(0);
        }
        return null;
    }

    public List<City> findByIdList(List<Integer> cityIdList){
        return cityRepository.findAllByIdIn(cityIdList);
    }

    public List<City> findCityListByIdList(List<Integer> cityIdList){
        List<City> cityList = new ArrayList<>();
        for (Integer  id: cityIdList) {
            cityList.add(findById(id));
        }
        return cityList;
    }

    public Integer findMaxIndexOfCities(){
        return cityRepository.findMaxIndexFromCities();
    }
}
