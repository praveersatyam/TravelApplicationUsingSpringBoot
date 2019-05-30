package com.travel.util;

import com.travel.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertUtil {

    public String findPathByCityList(List<City> cityList){
        String path = "";
        for (int i = 0; i < cityList.size(); i++) {
            if(i==cityList.size()-1){
                path+=cityList.get(i).getName();

            }
            else{
                path+=cityList.get(i).getName()+"->";
            }
        }
        return path;
    }
}
