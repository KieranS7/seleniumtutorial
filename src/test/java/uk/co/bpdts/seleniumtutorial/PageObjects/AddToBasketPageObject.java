package uk.co.bpdts.seleniumtutorial.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToBasketPageObject {

    private WebDriver driver;

    public AddToBasketPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void addSpecificItemToBasket(String addtobasket){
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}
