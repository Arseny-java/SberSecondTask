package com.weather.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFromJson {

    @JsonProperty("type")
    String type;

    @JsonProperty("query")
    String query;

    @JsonProperty("language")
    String language;

    @JsonProperty("unit")
    String unit;
}
