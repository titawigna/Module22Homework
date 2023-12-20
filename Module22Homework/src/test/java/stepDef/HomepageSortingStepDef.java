package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomepageSortingStepDef {

    HomePage homePage;

    public HomepageSortingStepDef(){
        this.homePage = new HomePage();

    }

    @When("User clicks sorting button")
    public void userClicksSortingButton() {
        homePage.clickSortingIcon();
    }

    @And("User clicks the sorting by price \\(low to high)")
    public void userClicksTheSortingByPriceLowToHigh() {
        homePage.selectSortingByPriceLtH();
    }

    @Then("List of products is sorted by price \\(low to high)")
    public void listOfProductsIsSortedByPriceLowToHigh() {
        homePage.verifyTheSortedListByPriceLtH();
    }



}
