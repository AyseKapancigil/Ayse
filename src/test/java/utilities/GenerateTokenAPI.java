package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GenerateTokenAPI {


    public static String getToken() {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("fondy_url")).build();
        spec.pathParams("first", "api", "second", "authenticate");//comes from swagger documents
        //Set the expected data
        /*
        {
  "password": "string",
  "rememberMe": true,
  "username": "string"
}
         */
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("password", "Fondy+");
        expectedData.put("rememberMe", true);
        expectedData.put("username", "FondyAPI");

        Response response = given().
                spec(spec).

                contentType(ContentType.JSON).
                body(expectedData).
                when().
                post("/{first}/{second}");

        JsonPath json = response.jsonPath();
        String token = json.getString("id_token");

        System.out.println("token  " + token);
        return token;

    }
}