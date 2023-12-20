package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDetailsPage {

    By checkoutButton = By.xpath("//*[@id=\"checkout\"]");
    By firstNameField = By.xpath("//*[@id=\"first-name\"]");
    By lastNameField = By.xpath("//*[@id=\"last-name\"]");
    By zipCodeField = By.xpath("//*[@id=\"postal-code\"]");
    By continueButton = By.xpath("//*[@id=\"continue\"]");
    By finishButton = By.xpath("//*[@id=\"finish\"]");
    By successMessageText = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public void inputFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);

    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public void successfulOrderMessage(String successMessage){
        assertTrue(driver.getPageSource().contains(successMessage));
    }





}
