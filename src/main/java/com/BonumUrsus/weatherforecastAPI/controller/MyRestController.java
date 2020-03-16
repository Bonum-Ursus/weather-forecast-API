package com.BonumUrsus.weatherforecastAPI.controller;

import com.BonumUrsus.weatherforecastAPI.dao.WeatherForecastDAO;
import com.BonumUrsus.weatherforecastAPI.entity.AccuWeatherForecast;
import com.BonumUrsus.weatherforecastAPI.entity.AccuweatherCity;
import com.BonumUrsus.weatherforecastAPI.entity.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {
    private WeatherForecastDAO weatherForecastDAO;

    @Autowired
    public MyRestController(WeatherForecastDAO weatherForecastDAO) {
        this.weatherForecastDAO = weatherForecastDAO;
    }

    @GetMapping("/forecast/{city}")
    public AccuWeatherForecast getWeatherForecast(@PathVariable("city") String city){
        String locationKey = getCities(city).getKey();
        String URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" +
                locationKey + "?apikey={apikey}";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("apikey", "3jzGfgr7z2sGvH6XuaA7L1gT7eAsgzVa");
        RestTemplate template = new RestTemplate();
        AccuWeatherForecast forEntity = template.getForObject(
                URL, AccuWeatherForecast.class, parameters);

        return forEntity;
    }

    public AccuweatherCity getCities(@PathVariable("city") String city){
        String URL = "http://dataservice.accuweather.com/locations/v1/cities/search?" +
                "apikey={apikey}&" +
                "q={q}";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("apikey", "3jzGfgr7z2sGvH6XuaA7L1gT7eAsgzVa");
        parameters.put("q", city);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccuweatherCity[]> entity = restTemplate.getForEntity(
                URL, AccuweatherCity[].class, parameters);
        return entity.getBody()[0];

    }

}
