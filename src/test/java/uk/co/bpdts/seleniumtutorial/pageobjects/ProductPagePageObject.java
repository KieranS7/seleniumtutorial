package uk.co.bpdts.seleniumtutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPagePageObject {

    private WebDriver driver;

    public ProductPagePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void addSpecificItemToBasket(){
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}
