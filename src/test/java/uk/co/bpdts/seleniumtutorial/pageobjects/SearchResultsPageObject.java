package uk.co.bpdts.seleniumtutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPageObject {
    private WebDriver driver;

    public SearchResultsPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public ProductPagePageObject findSpecficItemFromSearchResultsByTitle(String specificItemTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<WebElement> searchResults = wait
                .until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(
                                By.cssSelector("* > div > div > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div > a > h2")));
        try {
            for (WebElement element : searchResults) {
                if (element.getText().equals(specificItemTitle)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            // do nothing
        }

        return new ProductPagePageObject(driver);

    }



}
