package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepDef {

    ApiPage apiPage;

    public ApiStepDef(){
        this.apiPage = new ApiPage();

    }

    @Given("Prepare url for {string}")
    public void prepareUrlfor(String url){
        apiPage.prepareURL(url);
    }

    @And("Hit the GET API")
    public void hitTheGETAPI() {
        apiPage.hitTheGetAPI();
    }


    @Then("Validate status code is {int}")
    public void validateStatusCodeIs(int statusCode) {
        apiPage.validateStatusCode(statusCode);
    }

    @And("Validate response body GET list users data")
    public void validateResponseBodyGETListUsersData() {
        apiPage.validateResponseBody();
    }

    @And("Validate response JSON with JSONSchema {string}")
    public void validateResponseJSONWithJSONSchema(String fileName) {
        apiPage.validateJsonShcema(fileName);
    }


    @And("Hit the POST API")
    public void hitThePOSTAPI() {
        apiPage.hitThePOSTAPI();
    }

    @And("Validate response body POST user data")
    public void validateResponseBodyPOSTUserData() {
        apiPage.validatePOSTResponseBody();
    }

    @And("Hit the DELETE API")
    public void hitTheDELETEAPI() {
        apiPage.hitTheDELETEAPI();
    }

    @And("Hit the UPDATE API")
    public void hitTheUPDATEAPI() {
        apiPage.hitTheUPDATEAPI();
    }

    @And("Validate response body UPDATE user data")
    public void validateResponseBodyUPDATEUserData() {
        apiPage.validateUPDATEResponseBody();
    }
}
