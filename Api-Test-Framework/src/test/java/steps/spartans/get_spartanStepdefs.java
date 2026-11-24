package steps.spartans;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.tokenHelper;
import static io.restassured.RestAssured.given;

public class get_spartanStepdefs {
    private Response response;
    private RequestSpecification request;
    private static String BASE_URL = "http://localhost:8080/api/Spartans";
    tokenHelper token = new tokenHelper();

    @io.cucumber.java.en.When("^I press enter$")
    public void iPressEnter() {}

    @io.cucumber.java.en.Then("^I should see all the spartan information$")
    public void iShouldSeeAllTheSpartanInformation() {
       response = given()
               .baseUri(BASE_URL)
               .auth().oauth2(token.getBearerAPIKey())
               .get();
       response.prettyPrint();

    }
}
