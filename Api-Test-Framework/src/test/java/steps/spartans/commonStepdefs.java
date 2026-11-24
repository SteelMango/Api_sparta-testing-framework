package steps.spartans;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.tokenHelper;
import static io.restassured.RestAssured.given;



public class commonStepdefs {

    private static String BASE_URL = "http://localhost:8080/api/Spartans";
    private Response response;

    // Need to be authorised to be able to see the requests response
    @io.cucumber.java.en.Given("^I am on the spartan api$")
    public void iAmOnTheSpartanApi() {
        response = given()
                .get(BASE_URL);
    }
}
