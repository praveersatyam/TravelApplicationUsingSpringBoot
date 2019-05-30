package com.travel.repository;

import com.travel.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    public List<City> findAllByName(String name);

    public List<City> findAllByIdIn(List<Integer> idList);

    @Query("SELECT max(id) from City")
    public Integer findMaxIndexFromCities();
}
