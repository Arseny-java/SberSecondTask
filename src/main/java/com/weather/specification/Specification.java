package com.weather.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("HttpUrlsUsage")
public class Specification {

    private static final String BASE_URI = "http://api.weatherstack.com/current";

    public static RequestSpecification baseSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .build();
    }
}
