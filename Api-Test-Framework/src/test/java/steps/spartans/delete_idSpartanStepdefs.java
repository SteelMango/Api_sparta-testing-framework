package steps.spartans;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class delete_idSpartanStepdefs {
    // Remember about the auth token

    @When("^I enter an invalid id of a non-existent spartan$")
    public void iEnterAnInvalidIdOfANonExistentSpartan() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get an error$")
    public void iShouldGetAnError() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter a valid id to delete$")
    public void iEnterAValidId() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get http code (\\d+)$")
    public void iShouldGetHttpCode(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I create a new spartan with the body:")
    public void iCreateANewSpartanWithTheBody(String body) {
        // Send a PUT request for the spartan

    }

}
