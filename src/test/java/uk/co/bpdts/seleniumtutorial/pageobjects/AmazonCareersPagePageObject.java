package uk.co.bpdts.seleniumtutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AmazonCareersPagePageObject {
    private WebDriver driver;

    public AmazonCareersPagePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public JobListPageObject searchforLocation(String locationterm) {
        WebElement locationField = driver.findElements(By.id("location-typeahead")).get(1);
        locationField.sendKeys(locationterm);
        driver.findElement(By.id("search-button")).click();
        return new JobListPageObject(driver);
    }

    public JobListPageObject searchusingdropdown(String locationdd)
    {
        WebElement destination = driver.findElement(By.cssSelector("location-typeahead"));
        destination.sendKeys("lon");
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.click();

    }
}
