package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.OptimalChangePojo;
import testdata.Fondytestdata;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.GenerateTokenAPI.getToken;

public class UUID_2PostStepDefs {

    Response response;
    OptimalChangePojo actualData;

    Map<String, Map<String, Integer>> expectedData;

    @Given("user has submitted a value of  {string}")
    public void user_has_submitted_a_value_of(int penceSubmitted) {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://fondy.com").build();
        spec.pathParams("first", "api", "second", "optimalChange", "third", "request");
        response = given().headers("Authorization", "Bearer " + getToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).spec(spec).contentType(ContentType.JSON).body(Fondytestdata.getOptimalChange(penceSubmitted)).when().post("/{first}/{second}");

        actualData.setPenceSubmitted(penceSubmitted);

    }

    @Given("User generates token for Authorization")
    public void user_generates_token_for_authorization() {
        //GenerateTokenAPI class in utilities has been used.

    }

    @When("user send a post request with the required  payload")
    public void user_send_a_post_request_with_the_required_payload() {
        // expectedData=Fondytestdata.getOptimalChange(actualData.getPenceSubmitted());
        actualData = response.as(OptimalChangePojo.class);

    }

    @Then("user should receive a response with a status code of {int}")
    public void user_should_receive_a_response_with_a_status_code_of(Integer int1) {

        response.then().
                assertThat().
                statusCode(201).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 201 created");
    }

    @Then("user validates the response data")
    public void user_validates_the_response_data() {
        Assert.assertEquals(Fondytestdata.getOptimalChange(actualData.getPenceSubmitted()).get("pounds"), actualData.getPounds());
        Assert.assertEquals(Fondytestdata.getOptimalChange(actualData.getPenceSubmitted()).get("pence"), actualData.getPence());
    }
}


    /*
    To implement this functionality in Java using the Cucumber framework and a POJO as the response, you will need to do the following:
    Create a POJO class to represent the JSON response. The POJO should have fields for
    the "penceSubmitted" and "externalID" as well as a Map for the "pounds" and a Map for the "pence" fields.
    You can also include a "dateTime" field if you want to include the current date and time in the response.
    Create a method in your Test Data with Map to calculate the optimal change for the given amount of pence.
    This method should take in an integer representing the total number of pence and return a Map of the optimal change in pounds and pence.
    In your Cucumber feature file, define a scenario for testing the "POST /example/optimalChange" URLs.
    In your Cucumber step definition file, implement the steps for the scenario you defined in the feature file.
    These steps should include sending a POST request to the "/example/optimalChange" URL with the necessary data.
    Please check Fondytestdata class to be able to see the expected data.
    In your step definition file, use your POJO class to create an object to hold the response data from the POST request.
    Then, use the Maps in the Fondytestdata class to verify that the correct optimal change has been calculated and returned in the response.



         */