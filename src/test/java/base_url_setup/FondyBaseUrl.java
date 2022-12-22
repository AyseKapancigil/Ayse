package base_url_setup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class FondyBaseUrl {

    public static RequestSpecification spec;

    public static void fondySetup() {


        spec = new RequestSpecBuilder().setBaseUri("https://fondy.com").build();

    }

}
