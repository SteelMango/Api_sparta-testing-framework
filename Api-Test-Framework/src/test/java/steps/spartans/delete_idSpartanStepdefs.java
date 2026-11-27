package steps.spartans;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.tokenHelper;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class delete_idSpartanStepdefs {
    tokenHelper token = new tokenHelper();
    private Response response;
    private RequestSpecification request;
    private int validSpartanID;

    // Remember about the auth token
    @When("^I enter an invalid id of a non-existent spartan$")
    public void iEnterAnInvalidIdOfANonExistentSpartan() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter a valid id to delete$")
    public void iEnterAValidId() {
        System.out.println("Valid ID: " + validSpartanID);
    }

    @Then("^I should get http code (\\d+)$")
    public void iShouldGetHttpCode(int actual) {
        int expected = response.statusCode();
        assertEquals(actual,expected);
        System.out.println("Actual: " + actual + " Expected: " + expected);
    }

    @And("I create a new spartan with the body:")
    public void iCreateANewSpartanWithTheBody(String body) {
        // Send a POST request for the spartan + auth
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token.getBearerAPIKey())
                .body(body)
                .when()
                .post(commonStepdefs.id_url);
        response.prettyPrint();

        System.out.println("POST status: " + response.statusCode());
    }

    @And("I find the ID of the created Spartan")
    public void iFindTheIDOfTheCreatedSpartan() {
        // The firstname and the second name to this user is so unique that it can not be possibly duplicated

        // GET spartans and then filter by first name and second name to get the ID
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token.getBearerAPIKey())
                .when()
                .get(commonStepdefs.id_url);
        response.prettyPrint();

        validSpartanID = response.jsonPath().getInt("find {it.firstName == 'Bartholomewzx'}.id ");
    }

    @When("I enter an invalid id of a non-existent spartan {int}")
    public void iEnterAnInvalidIdOfANonExistentSpartanId(int id) {
        response = given()
                .auth().oauth2(token.getBearerAPIKey())
                .when()
                .delete(commonStepdefs.id_url + id);
        System.out.println("ID being deleted: " + id);
    }

    @Then("I should get a {int} code")
    public void iShouldGetAStatusCode(int actual) {
        int expected = response.getStatusCode();
        assertEquals(actual,expected);
        System.out.println("Actual: " + actual + " Expected: " + expected);

    }
}
