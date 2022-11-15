package com.weather.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("success")
    Boolean success;

    @JsonProperty("error")
    ErrorObject error;

}
