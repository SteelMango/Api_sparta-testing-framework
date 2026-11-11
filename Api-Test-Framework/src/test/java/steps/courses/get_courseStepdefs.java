package steps.courses;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.when;


public class get_courseStepdefs {
    private static final String url = "http://localhost:8080/api/Courses";

    @Given("^I am on the courses api$")
    public void iAmOnTheCoursesApi() {
        when().
                get(url).
        then().
                statusCode(200);
    }

    @When("^I press enter$")
    public void iPressEnter() {


    }

    @Then("^I should get all the information about the courses$")
    public void iShouldGetAllTheInformationAboutTheCourses() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
