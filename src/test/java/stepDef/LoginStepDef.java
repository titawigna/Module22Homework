package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


import static helper.Utility.driver;
import static org.junit.Assert.assertEquals;

public class LoginStepDef {

    LoginPage loginPage;

    public LoginStepDef(){
        this.loginPage = new LoginPage();
    }


    @Given("User is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage.goToLoginPage();
    }


    @And("User inputs the username {string}")
    public void userInputsTheUsername(String username) {
        loginPage.inputUsername(username);

    }

    @And("User inputs the password {string}")
    public void userInputsThePassword(String password) {
        loginPage.inputPassword(password);
    }

    @When("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        String url = "https://www.saucedemo.com/inventory.html";
        assertEquals(url, driver.getCurrentUrl());
    }

}
