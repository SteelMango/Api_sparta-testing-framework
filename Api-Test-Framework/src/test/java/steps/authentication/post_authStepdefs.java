package steps.authentication;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class post_authStepdefs {



    public void i_am_on_the_login_page() {}
    public void i_enter_valid_username() {}
    public void i_enter_valid_password() {}
    public void i_get_status_code() {}

    public void i_enter_invalid_username() {}
    public void i_enter_invalid_password() {}
    public void i_should_get_an_error_for_invalid_login_details() {}































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
