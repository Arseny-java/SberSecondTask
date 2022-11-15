package com.weather.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
    @JsonProperty("code")
    int code;

    @JsonProperty("type")
    String type;

    @JsonProperty("info")
    String info;
}
