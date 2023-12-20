package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Order;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;


public class CheckoutStepDef {

    HomePage homePage;
    OrderDetailsPage orderDetailsPage;
    LoginPage loginPage;
    LoginStepDef loginStepDef;

    public CheckoutStepDef(){
        this.homePage = new HomePage();
        this.orderDetailsPage = new OrderDetailsPage();
        this.loginPage = new LoginPage();
    }


    @And("User sees list of item {string}")
    public void userSeesListOfItem(String itemName) {
        homePage.seeTshirtItem();
    }

    @When("User adds an item to the cart")
    public void userAddsAnItemToTheCart() {
        homePage.addItemToCart();
    }

    @And("Cart number change according to the item added")
    public void cartNumberChangeAccordingToTheItemAdded() {
        homePage.verifyCartQtyNo();
    }

    @And("User clicks the cart icon")
    public void userClicksTheCartIcon() {
        homePage.clickCartIcon();
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() {
        orderDetailsPage.clickCheckoutButton();
    }

    @And("User fills in the first name {string}")
    public void userFillsInTheFirstName(String firstName) {
        orderDetailsPage.inputFirstName(firstName);
    }

    @And("User fills in the last name {string}")
    public void userFillsInTheLastName(String lastName) {
        orderDetailsPage.inputLastName(lastName);
    }

    @And("User fills in the zip code {string}")
    public void userFillsInTheZipCode(String zipCode) {
        orderDetailsPage.inputZipCode(zipCode);
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() {
        orderDetailsPage.clickContinueButton();
    }

    @And("User clicks finish button")
    public void userClicksFinishButton() {
        orderDetailsPage.clickFinishButton();
    }

    @Then("Order is successfully made with message {string}")
    public void orderIsSuccessfullyMadeWithMessage(String successMessage) {
        orderDetailsPage.successfulOrderMessage(successMessage);
    }
}
