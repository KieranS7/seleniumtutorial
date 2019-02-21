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

    public void selectingJobCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement catButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/p[contains(text(), \"Software Development\")]/..")));
        catButton.click();
    }

    public void selectingDistance() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement distanceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div[2]/content/div/div/div[1]/div/div[6]/div/fieldset/div[2]/button[1]")));
        distanceButton.click();
    }

    public void selectingBusinessCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement busCatButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='desktopFilter_business_category']//p[@class='label-text'][contains(text(),'Prime Video')]")));
        busCatButton.click();
    }

    public void selectingJob() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement jobButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='sb-site']/div[@id='main-content']/div[@class='search-page']/div[@data-react-class='SearchContent']/div[@class='search-content']/div[@class='container']/content/div[@class='search-container']/div[@class='row']/div[@class='col-md-8 search-page-job-list']/div[@class='row']/div[@class='job-tile-lists col-12']/div[4]/a[1]/div[1]")));
        jobButton.click();
    }
    public void applyingForJob() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("search-content-cover")));
        WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#apply-button")));
        applyButton.click();
}
}