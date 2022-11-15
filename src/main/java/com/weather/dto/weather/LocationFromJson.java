package com.weather.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationFromJson {

    @JsonProperty("name")
    String name;

    @JsonProperty("country")
    String country;

    @JsonProperty("region")
    String region;

    @JsonProperty("lat")
    String lat;

    @JsonProperty("lon")
    String lon;

    @JsonProperty("timezone_id")
    String timezoneId;

    @JsonProperty("localtime")
    String localtime;

    @JsonProperty("localtime_epoch")
    int localtime_epoch;

    @JsonProperty("utc_offset")
    String utcOffset;





}
