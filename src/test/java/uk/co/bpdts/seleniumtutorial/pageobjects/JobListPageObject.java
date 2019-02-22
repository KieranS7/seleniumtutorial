package uk.co.bpdts.seleniumtutorial.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobListPageObject {
    private WebDriver driver;

    public JobListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectingJobCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement catButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/p[contains(text(), \"" + category + "\")]/..")));
        catButton.click();
    }

    public void selectingDistance(int distance) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement distanceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), \"" + distance + "\")]")));
        distanceButton.click();
    }

    public void selectDistanceOfFive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement distanceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), \"5\")]")));
        distanceButton.click();
    }

    public void selectingBusinessCategory(String label) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement busCatButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/p[contains(text(), \"" + label + "\")]/..")));
        ;
        busCatButton.click();
    }

    public void selectingJob(String job) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement jobButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3[contains(text(), \"" + job + "\")]/../../../..)[3]")));
        jobButton.click();
    }

    public void applyingForJob() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#apply-button")));
        applyButton.click();
    }


}