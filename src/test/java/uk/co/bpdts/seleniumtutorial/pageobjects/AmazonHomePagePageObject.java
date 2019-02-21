package uk.co.bpdts.seleniumtutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePagePageObject {
    private WebDriver driver;


    public AmazonHomePagePageObject(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }


    public SearchResultsPageObject searchForItem(String searchterm) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchterm);
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();

        return new SearchResultsPageObject(driver);
    }

    public AmazonCareersPagePageObject clickoncareers() {
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]/a")).click();
        return new AmazonCareersPagePageObject(driver);
    }


}