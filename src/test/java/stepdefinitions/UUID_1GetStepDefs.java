package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pojo.OptimalChangePojo;
import testdata.Fondytestdata;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.GenerateTokenAPI.getToken;

public class UUID_1GetStepDefs {
Response response;
OptimalChangePojo actualData;



    @Given("user sends a get request for submitting with \"\"UUID_{int}\"\"")
    public void user_sends_a_get_request_for_submitting_with_uuid(Integer int1) {

       RequestSpecification spec=  new RequestSpecBuilder().setBaseUri("https://fondy.com").build();
      spec.pathParams("first","get","second","optimalChange","third", "id").queryParam("","");
       response = given().headers("Authorization", "Bearer " + getToken(),
              "Content-Type", ContentType.JSON,
               "Accept", ContentType.JSON).spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Given("user generates token for authorization")
    public void user_generates_token_for_authorization() {
        //GenerateTokenAPI class in utilities has been used.

    }
    @When("user retrieves the optimal change using the external ID")
    public void user_retrieves_the_optimal_change_using_the_external_id() {


    }
    @When("user converts json data to java with de-serialization")
    public void user_converts_json_data_to_java_with_de_serialization() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        actualData= objectMapper.readValue(response.asString(), OptimalChangePojo.class);


    }
    @Then("I should receive a response with a status code of {int}")
    public void i_should_receive_a_response_with_a_status_code_of(Integer int1) {

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
    }
    @Then("user should receive a response with the following  information pounds and pence")
    public void user_should_receive_a_response_with_the_following_information_pounds_and_pence() {

        Assert.assertEquals(Fondytestdata.getOptimalChange(actualData.getPenceSubmitted()).get("pounds"), actualData.getPounds());
        Assert.assertEquals(Fondytestdata.getOptimalChange(actualData.getPenceSubmitted()).get("pence"), actualData.getPence());

    }

}

  /*To implement this functionality in Java using the Cucumber framework and a POJO as the response, you will need to do
   the following:
   Create a POJO class to represent the JSON response. The POJO should have fields for
   the "penceSubmitted" and "externalID" as well as a Map for the "pounds" and a Map for the "pence" fields.
   You can also include a "dateTime" field if you want to include the current date and time in the response.
   Create a method in your Test Data with Map to calculate the optimal change for the given amount of pence.
   This method should take in an integer representing the total number of pence and return a Map of the optimal change in pounds and pence.
   In your Cucumber feature file, define a scenario for testing the "GET" /example/optimalChange/id" URLs.
   In your Cucumber step definition file, implement the steps for the scenario you defined in the feature file.
   These steps should include sending a GET request to the "/example/optimalChange" URL with the necessary data.
   Please check Fondytestdata class inside the testdata package to be able to see the expected data.
   In your step definition file, use your POJO class to create an object to hold the response data from the GET request.
   Then, use the Maps in the Fondytestdata class to verify that the correct optimal change has been calculated and returned in the response.

 */
