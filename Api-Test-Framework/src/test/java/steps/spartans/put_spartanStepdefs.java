package steps.spartans;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.tokenHelper;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class put_spartanStepdefs {
    tokenHelper token = new tokenHelper();
    private Response response;
    private RequestSpecification request;
    private static String BASE_URL = "http://localhost:8080/api/Spartans/";

    @Then("I should get a HTTP code {int}")
    public void iShouldGetAHTTPCode(int expected) {
        int actual = response.statusCode();
        assertEquals(expected,actual);
    }

    @When("I input invalid spartan credentials with body {int}:")
    public void iInputInvalidSpartanCredentialsWithBody(int id, String body) {
        response = given()
                .auth().oauth2(token.getBearerAPIKey())
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .put(BASE_URL +id)
                .then()
                .log().all()
                .extract()
                .response();
    }


    @Given("I am on the spartan put api with {int}")
    public void iAmOnTheSpartanPutApiWithId(int id) {
        response = given()
                .baseUri(BASE_URL + id)
                .auth().oauth2(token.getBearerAPIKey())
                .get();
        System.out.println("Getting Authenticated with BearerKey ");
    }

    @When("I input valid spartan credentials with body with {int}:")
    public void iInputValidSpartanCredentialsWithBodyWithId(int id, String body) {
        response = given()
                .auth().oauth2(token.getBearerAPIKey())
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .put(BASE_URL +id)
                .then()
                .log().all()
                .extract()
                .response();

    }
}
