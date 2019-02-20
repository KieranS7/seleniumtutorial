package uk.co.bpdts.seleniumtutorial;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AmazonAddToBasketTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",this.getClass().getClassLoader().getResource("chromedriver").getPath());
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchForProductAndAddToBasket() {
        driver.get("https://www.amazon.co.uk");
        assertThat("URL is wrong",driver.getCurrentUrl(),is("https://www.amazon.co.uk/"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

