package com.collectapi.cucumber.stepdefs;

import com.collectapi.casesinfo.CasesSteps;
import com.collectapi.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;


public class CovidCasesSteps extends TestUtils {

    //static declaration of response, so that we can use it for multiple steps if needed
    static ValidatableResponse response;

    //logger is defined to print logs
    private static final Logger log = LogManager.getLogger(CovidCasesSteps.class.getName());


    //@Steps to reference variable of CasesSteps class
    @Steps
    CasesSteps casesSteps;

    @When("^user creates a get request by entering the Country Name as \"([^\"]*)\"$")
    public void userCreatesAGetRequestByEnteringTheCountryNameAs(String countryName) {
        response = casesSteps.getTotalCovidCasesByCountryNames(countryName);
        log.info("Sending GET request with country as query parameter: " + countryName);
    }

    @Then("^user should be able to see the total cases of covid for UK$")
    public void userShouldBeAbleToSeeTheTotalCasesOfCovidForUK() {
        response.statusCode(200)
                .log().all();
        //Extracting the total number of cases from the response
        String totalCovidCases = response.extract().path("result[0].totalCases");
        log.info("User should be able to see the total COVID cases for UK is: " + totalCovidCases);
    }

    @And("^user verifies that the country is \"([^\"]*)\"$")
    public void userVerifiesThatTheCountryIs(String countryName) {
        //Extracting country name from the response
        String countryNameFromResponse = response.extract().path("result[0].country");
        //Assert.assertThat(countryNameFromResponse, equalTo(countryName));
        response.body("result[0].country", equalTo(countryName));
        log.info("User verifies that the country name in the received response is :" + countryNameFromResponse);
    }
}
