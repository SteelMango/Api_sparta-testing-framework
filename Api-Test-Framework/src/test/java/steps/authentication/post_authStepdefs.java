package steps.authentication;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class post_authStepdefs {
    private static String BASE_URL = "http://localhost:8080/Auth/login";
    private Response response;
    private RequestSpecification request;
    private String username;
    private String password;
    private String invalidUsername;
    private String invalidPassword;

    @Given("I am on the login endpoint")
    public void iAmOnTheLoginEndpoint() {
        request = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    @When("I enter valid username {string}")
    public void iEnterValidUsername(String username) {
        this.username = username;
    }

    @And("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        this.password = password;

    }

    @Then("I get status code {int}")
    public void iGetStatusCode(int expected) {
        // get the password and username together using Map
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        response = request.body(credentials).post();
        int actual = response.getStatusCode();

        assertEquals(expected,actual);
    }

    @When("I enter invalid username {string}")
    public void iEnterInvalidUsername(String invalidUsername) {
    this.invalidUsername = invalidUsername;
    }

    @And("I enter invalid password {string}")
    public void iEnterInvalidPassword(String invalidPassword) {
     this.invalidPassword = invalidPassword;
    }

    @Then("I should get an error for invalid login details")
    public void iShouldGetAnErrorForInvalidLoginDetails() {
        // get invalid password and invalid username together using map
        Map<String, String> invalidCreds = new HashMap<>();
        invalidCreds.put("username", invalidUsername);
        invalidCreds.put("password",invalidPassword);

        // get the error details
        response = request.body(invalidCreds).post();
        String actual = response.jsonPath().getString("title");
        String expected = "Unauthorized";

        assertEquals(expected, actual);


    }


}
