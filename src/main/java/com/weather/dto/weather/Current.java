package com.weather.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Current {

    @JsonProperty("observation_time")
    String observationTime;

    @JsonProperty("temperature")
    int temperature;

    @JsonProperty("weather_code")
    int weatherCode;

    @JsonProperty("weather_icons")
    List<String> weatherIcons;

    @JsonProperty("weather_descriptions")
    List<String> weatherDescriptions;

    @JsonProperty("wind_speed")
    int windSpeed;

    @JsonProperty("wind_degree")
    int windDegree;

    @JsonProperty("wind_dir")
    String windDir;

    @JsonProperty("pressure")
    int pressure;

    @JsonProperty("precip")
    int precip;

    @JsonProperty("humidity")
    int humidity;

    @JsonProperty("cloudcover")
    int cloudcover;

    @JsonProperty("feelslike")
    int feelslike;

    @JsonProperty("uv_index")
    int uvIndex;

    @JsonProperty("visibility")
    int visibility;

    @JsonProperty("is_day")
    String isDay;
}

