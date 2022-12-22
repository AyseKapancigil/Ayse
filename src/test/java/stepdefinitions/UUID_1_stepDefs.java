package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.OptimalChangePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.GenerateTokenAPI.getToken;

public class UUID_1_stepDefs {
    Response response;
   OptimalChangePojo[] change;


 @Given("user sends a get request for  submitting a value of {string} pence with external ID \"\"UUID_{int}\"\"")
 public void user_sends_a_get_request_for_submitting_a_value_of_pence_with_external_id_uuid(String string, Integer int1) {

  RequestSpecification spec=  new RequestSpecBuilder().setBaseUri("https://fondy.com").build();
        spec.pathParams("first","api","second","").queryParam("id","");
       response = given().headers("Authorization", "Bearer " + getToken(),
                "Content-Type", ContentType.JSON,
               "Accept", ContentType.JSON).spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();



 }
 @When("user retrieves the optimal change for the submitted value using the external ID")
 public void user_retrieves_the_optimal_change_for_the_submitted_value_using_the_external_id() {

 }
 @When("user converts json data to java")
 public void user_converts_json_data_to_java() throws IOException {

  ObjectMapper obj = new ObjectMapper();
       change= obj.readValue(response.asString(), OptimalChangePojo[].class);


 }


    @Then("user should receive a response with the following  information {string} {string} and {string}")
    public void userShouldReceiveAResponseWithTheFollowingInformationAnd(String arg0, String arg1, String arg2) {
    }


}
