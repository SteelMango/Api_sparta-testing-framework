package steps.authentication;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class post_authStepdefs {
    private static final String url = "http://localhost:8080/api/Courses";

    @Given("^I am on the courses api$")
    public void iAmOnTheCoursesApi() {





    }

    @When("^I press enter$")
    public void iPressEnter() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get all the information about the courses$")
    public void iShouldGetAllTheInformationAboutTheCourses() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
