package com.BonumUrsus.weatherforecastAPI.dao;

import com.BonumUrsus.weatherforecastAPI.entity.WeatherForecast;


public interface WeatherForecastDAO {
    WeatherForecast getWeatherForecast(int id);
}
