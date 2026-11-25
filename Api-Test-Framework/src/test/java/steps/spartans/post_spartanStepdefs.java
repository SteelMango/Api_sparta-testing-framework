package steps.spartans;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.tokenHelper;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class post_spartanStepdefs {
    tokenHelper token = new tokenHelper();
    private Response response;
    private RequestSpecification request;

   @When("I send over body:")
   public void iSendOverBody(String body) {
       // Login with Bearer Token
       response = given()
               .contentType(ContentType.JSON)
               .auth().oauth2(token.getBearerAPIKey())
               .body(body)
               .when()
               .post(commonStepdefs.id_url);
       response.prettyPrint();


   }

    @Then("I should get status {int}")
    public void iShouldGetStatus(int actual) {
       int expected = response.statusCode();
        assertEquals(actual,expected);
    }

    @Then("I should get a {int}")
    public void iShouldGetA(int actual) {
      int expected = response.statusCode();
      assertEquals(actual,expected);
    }
}
