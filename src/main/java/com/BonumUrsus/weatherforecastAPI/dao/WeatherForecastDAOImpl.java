package com.BonumUrsus.weatherforecastAPI.dao;

import com.BonumUrsus.weatherforecastAPI.entity.WeatherForecast;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class WeatherForecastDAOImpl implements WeatherForecastDAO {
    private EntityManager entityManager;

    @Autowired
    public WeatherForecastDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public WeatherForecast getWeatherForecast(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from WeatherForecast where id=:theId");
        query.setParameter("theId", id);
        WeatherForecast weatherForecast = (WeatherForecast) query.getSingleResult();
        return weatherForecast;
    }
}
