package com.BonumUrsus.weatherforecastAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuweatherCity {
    @JsonProperty("Key")
    private String Key;
    @JsonProperty("LocalizedName")
    private String LocalizedName;

}
