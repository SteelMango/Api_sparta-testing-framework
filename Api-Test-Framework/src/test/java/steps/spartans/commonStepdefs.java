package steps.spartans;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class commonStepdefs {
    private static String BASE_URL = "http://localhost:8080/api/Spartans";
    public static String id_url = "http://localhost:8080/api/Spartans/";
    private Response response;

    // Need to be authorised to be able to see the requests response
    @io.cucumber.java.en.Given("^I am on the spartan api$")
    public void iAmOnTheSpartanApi() {
        response = given()
                .get(BASE_URL);
    }

    // Makes it easier to just add the id at the end
    @Given("I am on the sparta api for an id")
    public void iAmOnTheSpartaApiForAnId() {
        response = given()
                .get(id_url);
    }
}
