package uk.co.bpdts.seleniumtutorial;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.bpdts.seleniumtutorial.PageObjects.AddToBasketPageObject;
import uk.co.bpdts.seleniumtutorial.PageObjects.AmazonHomePagePageObject;
import uk.co.bpdts.seleniumtutorial.PageObjects.SearchResultsPageObject;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class AmazonAddToBasketTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver").getPath());
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk");
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchForProductAndAddToBasket() throws InterruptedException {
        AmazonHomePagePageObject amazonHomePagePageObject = new AmazonHomePagePageObject(driver);
        SearchResultsPageObject searchResultsPageObject = amazonHomePagePageObject.searchForItem("Lee Child");
        searchResultsPageObject.findSpecficItemFromSearchResultsByTitle("Past Tense: (Jack Reacher 23)");

        assertThat("not on book product page", driver.getTitle(), containsString("Past Tense: (Jack Reacher 23)"));

        AddToBasketPageObject addToBasket= new AddToBasketPageObject(driver);
        addToBasket.addSpecificItemToBasket();


        /*driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.cssSelector("#hlb-ptc-btn-native")).click();
        assertThat("check on signin page", driver.getTitle(), containsString("Sign In"));*/
    }


    //@After
    public void tearDown() {
        driver.quit();
    }

}

