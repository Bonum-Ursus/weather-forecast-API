package com.BonumUrsus.weatherforecastAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "weather_forecast")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "resource")
    private String resource;

    @NonNull
    @Column(name = "date")
    private String date;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "temperature")
    private String temperature;
}
