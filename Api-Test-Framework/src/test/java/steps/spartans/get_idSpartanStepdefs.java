package steps.spartans;

// Everything in the Spartan endpoint
public class get_idSpartanStepdefs {
    private int validId;

    @io.cucumber.java.en.When("^I enter a valid id$")
    public void iEnterAValidId() {
        int id = 1;
        this.validId = id;
    }

    @io.cucumber.java.en.Then("^I should see information about the id$")
    public void iShouldSeeInformationAboutTheId() {


    }




















    @io.cucumber.java.en.When("^I enter an invalid id for the spartan api$")
    public void iEnterAnInvalidId() {

    }

    @io.cucumber.java.en.Then("^I should get an error about invalid id input$")
    public void iShouldGetAnErrorAboutInvalidIdInput() {

    }
}
