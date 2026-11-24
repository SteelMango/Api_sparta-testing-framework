package utils;// logins in, gets the response that is the bearer token and then saves it

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class tokenHelper {
    private RequestSpecification request;
    private Response response;
    private String URL = "http://localhost:8080/Auth/login";

    public String getBearerAPIKey(){
        // Create Login Details
        Map<String, String> login = new HashMap<>();
        login.put("username","sparta");
        login.put("password", "global");

        // Login to the /Auth/login endpoint
        response = given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(login)
                .post();

        String token = response.jsonPath().getString("token");

        return token;
    }
}
