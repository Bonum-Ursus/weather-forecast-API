package com.BonumUrsus.weatherforecastAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum {
    @JsonProperty("Value")
    private String value;

    @JsonProperty("Unit")
    private String unit;
}
