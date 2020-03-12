package com.BonumUrsus.weatherforecastAPI.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "weather_forecast")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
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
