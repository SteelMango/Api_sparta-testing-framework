package steps.courses;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class get_idCourseStepdefs {
    private final String url = "http://localhost:8080/api/Courses/";
    private Response response;

    @Given("^I am on the courses id api$")
    public void iAmOnTheCoursesIdApi() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @When("^I enter letters$")
    public void iEnterLetters() {
        String letters = "TEST";
        String letter_url = url + letters;

        response = when().get(letter_url);
    }

    @Then("^I should get an error about invalid input$")
    public void iShouldGetAnErrorAboutInvalidInput() {

        int actual = response.getStatusCode();
        assertEquals(400, actual);
        assertEquals("One or more validation errors occurred.", response.jsonPath().getString("title"));

    }

    @When("^I enter a negative number in the query$")
    public void iEnterANegativeNumberInTheQuery() {
        int negativeNumber = -1;
        String negativeNumberUrl = url + negativeNumber;
        response = when().get(negativeNumberUrl);

    }

    @Then("^An error about negative numbers should appear$")
    public void anErrorAboutNegativeNumbersShouldAppear() {
        assertEquals(404, response.getStatusCode());

    }

    @When("^I enter an invalid character$")
    public void iEnterAnInvalidCharacter() {
        response = when().get(url+'%');
    }

    @Then("^An error should appear$")
    public void anErrorShouldAppear() {
        String expected = "One or more validation errors occurred.";
        assertEquals(expected, response.jsonPath().getString("title"));
    }










    @When("^I enter an invalid id query$")
    public void iEnterAnInvalidIdQuery() {
        response = when().get(url+6);
    }









    @Then("^I should get a http code (\\d+)$")
    public void iShouldGetAHttpCode(int code) {
        assertEquals(code,response.getStatusCode());
    }

    @When("^I enter a valid id query$")
    public void iEnterAValidIdQuery() {
        response = when().get(url+1);
    }
}
