package com.collectapi.casesinfo;

import com.collectapi.constants.EndPoints;
import com.collectapi.utils.PropertyReader;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 *  Create automation script for following user story in BDD format.
 ** User story
 * As a user, I want to check total cases of covid for UK
 *
 * Details to use
 * API:   https://api.collectapi.com/corona/countriesData
 * Query param : country
 *--header authorization: apikey 3kOUS3z1UjXKDsEYelv8DH:5zziLhgrybsWS7OyglFdk3
 *--header content-type: application/json’
 */

public class CasesSteps {

    //Reading the provided APIKey stored in properties file
    String apiKey = PropertyReader.getInstance().getProperty("apikey");

    //@Step annotation will show description of the step in Serenity Report
    @Step("Sending GET request with query params COUNTRY = UK")
    public ValidatableResponse getTotalCovidCasesByCountryNames(String country){
        return SerenityRest.given().log().all()
                .header("authorization", apiKey)
                .contentType(ContentType.JSON)
                .queryParams("country", country)
                .when()
                .get(EndPoints.GET_COVID_DATA_FOR_ALL_COUNTRIES)
                .then();
    }
}
