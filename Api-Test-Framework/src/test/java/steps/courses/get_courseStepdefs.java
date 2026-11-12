package steps.courses;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThan;


public class get_courseStepdefs {
    private static final String url = "http://localhost:8080/api/Courses";
    private Response response;

    @Given("^I am on the courses api$")
    public void iAmOnTheCoursesApi() {
        response = when().get(url);
    }

    @When("^I get code 200$")
    public void iPressEnter() {
        response.then().statusCode(200);
    }

    @Then("^I should get all the information about the courses$")
    public void iShouldGetAllTheInformationAboutTheCourses() {
        response.then()
                .contentType("application/json")
                .body("size()", greaterThan(0));
        response.prettyPrint();
    }
}
