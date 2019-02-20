package uk.co.bpdts.seleniumtutorial.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePagePageObject {
    private WebDriver driver;


    public AmazonHomePagePageObject(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }



    public SearchResultsPageObject searchForItem(String searchterm) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchterm);
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();

        return new SearchResultsPageObject(driver);
}
}