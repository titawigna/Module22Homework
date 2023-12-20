package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static helper.Utility.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class HomePage {

    By itemTshirtDisplayed = By.xpath("//*[@id=\"item_1_title_link\"]/div");
    By addToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By cartQtyNo = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By sortingIcon = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By item1price = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    By item2price = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div");
    By item3price = By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div");
    By item4price = By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div");
    By item5price = By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[2]/div");
    By item6price = By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div");

    public void seeTshirtItem(){
        WebElement itemTshirtLoc = driver.findElement(itemTshirtDisplayed);
        assertEquals("Sauce Labs Bolt T-Shirt", itemTshirtLoc.getText());
    }

    public void addItemToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void verifyCartQtyNo(){
        WebElement cartQtyNumber = driver.findElement(cartQtyNo);
        assertEquals("1", cartQtyNumber.getText());
    }

    public void clickCartIcon(){
        driver.findElement(cartIcon).click();

    }

    public void clickSortingIcon(){
        driver.findElement(sortingIcon).click();
    }

    public void selectSortingByPriceLtH(){
        WebElement selectElement;
        selectElement = driver.findElement(sortingIcon);

        Select selectObject = new Select(selectElement);

        selectObject.selectByVisibleText("Price (low to high)");
    }

    public void verifyTheSortedListByPriceLtH(){

        //dapetin list harga 6-6nya
        //transform string to int
        //looping bandingin yg index pertama lebih kecil dari kedua
        //index 0 dengan index 0+1
        //index 1 dengan index 1+1

        //assertEquals(priceListDisplayed, priceListDisplayed);


        String price1 = driver.findElement(item1price).getText();
        float price1new = Float.parseFloat(price1.substring(1)) ;

        String price2 = driver.findElement(item2price).getText();
        float price2new = Float.parseFloat(price2.substring(1)) ;

        String price3 = driver.findElement(item3price).getText();
        float price3new = Float.parseFloat(price3.substring(1)) ;

        String price4 = driver.findElement(item4price).getText();
        float price4new = Float.parseFloat(price4.substring(1)) ;

        String price5 = driver.findElement(item5price).getText();
        float price5new = Float.parseFloat(price5.substring(1)) ;

        String price6 = driver.findElement(item6price).getText();
        float price6new = Float.parseFloat(price6.substring(1)) ;

        float[] listOfPrice = {price1new, price2new, price3new, price4new, price5new, price6new};

        System.out.println("Length dari array adalah = " + (listOfPrice.length));

        //lengthnya 6
        //indexnya 0, 1, 2, 3, 4, 5

        for(int i = 0; i < listOfPrice.length-1 ; i++){
            assertTrue(listOfPrice[i] <= listOfPrice[i+1] );
        }



    }



}
