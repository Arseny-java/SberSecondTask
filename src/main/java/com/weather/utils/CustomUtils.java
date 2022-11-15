package com.weather.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.weather.dto.error.ErrorResponse;
import com.weather.dto.weather.Current;
import com.weather.dto.weather.LocationFromJson;
import com.weather.dto.weather.RequestFromJson;
import com.weather.dto.weather.ResponseFromWeatherSite;

import java.util.ArrayList;
import java.util.List;

import static com.weather.specification.Specification.baseSpecification;
import static io.restassured.RestAssured.given;
@SuppressWarnings("FieldMayBeFinal")
public class CustomUtils {
    private static final String KEY = "ca297014cf42c3269c14e24f360ad927";

    private static ObjectMapper mapper = new ObjectMapper();

    public String getResponse(String city) {
        return given()
                .urlEncodingEnabled(false)
                .spec(baseSpecification())
                .queryParam("access_key", KEY)
                .queryParam("query", city)
                .get()
                .then()
                .statusCode(200)
                .extract().body().jsonPath().prettify();
    }

    public String getResponse(String city, String key) {
        return given()
                .urlEncodingEnabled(false)
                .spec(baseSpecification())
                .queryParam("access_key", key)
                .queryParam("query", city)
                .get()
                .then()
                .extract().body().jsonPath().prettify();
    }


    public ResponseFromWeatherSite getResponseObject(String response) {
        ResponseFromWeatherSite responseObject;
        try {
            responseObject = mapper.readValue(response, ResponseFromWeatherSite.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return responseObject;
    }

    public ErrorResponse getErrorObject(String response) {
        ErrorResponse errorResponse;
        try {
            errorResponse = mapper.readValue(response, ErrorResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return errorResponse;
    }

    public ResponseFromWeatherSite getRandomData(ResponseFromWeatherSite actualResponse) {
        Faker faker = new Faker();
        String locationName = actualResponse.getLocation().getName();
        List<String> randomList = new ArrayList<>();
        randomList.add(faker.animal().name());
        RequestFromJson requestFromJson = new RequestFromJson(
                faker.pokemon().name(),
                faker.pokemon().name(),
                faker.pokemon().name(),
                faker.pokemon().name());

        LocationFromJson locationFromJson = new LocationFromJson(
                locationName,
                faker.gameOfThrones().character(),
                faker.gameOfThrones().character(),
                faker.gameOfThrones().character(),
                faker.gameOfThrones().character(),
                faker.gameOfThrones().character(),
                faker.gameOfThrones().character(),
                faker.number().randomDigit(),
                faker.gameOfThrones().character());

        Current current = new Current(
                faker.animal().name(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                randomList,
                randomList,
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.animal().name(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.number().randomDigit(),
                faker.animal().name());
        return new ResponseFromWeatherSite(requestFromJson, locationFromJson, current);
    }
}
