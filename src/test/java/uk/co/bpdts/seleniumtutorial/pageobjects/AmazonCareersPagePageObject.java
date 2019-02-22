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
        WebDriverWait wait = new WebDriverWait(driver,5);
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='tt-menu tt-open']//div[@class='tt-dataset tt-dataset-location-results']")));
        System.out.println("total locations" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Greater London")) {
                list.get(i).click();
            }
        }
        return new JobListPageObject(driver);
    }
}
