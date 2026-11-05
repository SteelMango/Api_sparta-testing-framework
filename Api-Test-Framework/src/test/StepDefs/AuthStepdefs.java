import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;


public class AuthStepdefs {
    private final String BASE_URI = ""

    @Given("^I am on the login endpoint$")
    public void iAmOnTheLoginEndpoint() {

    }

    @When("^I enter valid username \"([^\"]*)\"$")
    public void iEnterValidUsername(String username) {
    }

    @And("^I enter valid password \"([^\"]*)\"$")
    public void iEnterValidPassword(String password) {
    }

    @Then("^I get status code (\\d+)$")
    public void iGetStatusCode(int statusCode) {
    }

    @When("^I enter invalid username \"([^\"]*)\"$")
    public void iEnterInvalidUsername(String username) {
    }

    @And("^I enter invalid password \"([^\"]*)\"$")
    public void iEnterInvalidPassword(String password) {
    }

    @Then("^I should get an error for invalid login details$")
    public void iShouldGetAnErrorForInvalidLoginDetails() {
    }
}