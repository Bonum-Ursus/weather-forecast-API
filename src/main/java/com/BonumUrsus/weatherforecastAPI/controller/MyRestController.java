package com.BonumUrsus.weatherforecastAPI.controller;

import com.BonumUrsus.weatherforecastAPI.dao.WeatherForecastDAO;
import com.BonumUrsus.weatherforecastAPI.entity.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    private WeatherForecastDAO weatherForecastDAO;

    @Autowired
    public MyRestController(WeatherForecastDAO weatherForecastDAO) {
        this.weatherForecastDAO = weatherForecastDAO;
    }

    @GetMapping("/forecast/{id}")
    public WeatherForecast getWeatherForecast(@PathVariable("id") int id){
        return weatherForecastDAO.getWeatherForecast(id);
    }
}
