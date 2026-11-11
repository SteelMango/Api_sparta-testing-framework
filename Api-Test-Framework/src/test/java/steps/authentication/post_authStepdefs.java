package steps.authentication;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class post_authStepdefs {
    @Given("I am on the login endpoint")
    public void iAmOnTheLoginEndpoint() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I enter valid username {string}")
    public void iEnterValidUsername(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I enter valid password {string}")
    public void iEnterValidPassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I get status code {int}")
    public void iGetStatusCode(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I enter invalid username {string}")
    public void iEnterInvalidUsername(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I enter invalid password {string}")
    public void iEnterInvalidPassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I should get an error for invalid login details")
    public void iShouldGetAnErrorForInvalidLoginDetails() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
