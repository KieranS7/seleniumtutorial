package uk.co.bpdts.seleniumtutorial;

import jdk.vm.ci.meta.Local;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import uk.co.bpdts.seleniumtutorial.pageobjects.*;
import uk.co.bpdts.seleniumtutorial.utils.Parallelized;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(Parallelized.class)
public class AmazonAddToBasketTest {

    private WebDriver driver;
    private static JSONObject config;

    public static final String USERNAME = "kieranslater1";
    public static final String AUTOMATE_KEY = "y3n5xy8YPR7zDKhpGybY";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Parameterized.Parameter(value = 0)
    public int taskID;

    @Parameterized.Parameters
    public static Iterable<? extends Object> data() throws Exception {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/parallel.conf.json"));
        int envs = ((JSONArray)config.get("environments")).size();

        List<Integer> taskIDs = new ArrayList<Integer>();
        for(int i=0; i<envs; i++) {
            taskIDs.add(i);
        }

        return taskIDs;
    }

    @Before
    public void setUp() throws MalformedURLException {
        JSONArray envs = (JSONArray) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(taskID);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("key");
        }

        String app = System.getenv("BROWSERSTACK_APP_ID");
        if(app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }


        driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
     driver.get("https://www.amazon.co.uk");
        driver.manage().window().maximize();
    }

    //@Test
    public void testSearchForProductAndAddToBasket() throws InterruptedException {
        AmazonHomePagePageObject amazonHomePagePageObject = new AmazonHomePagePageObject(driver);
        SearchResultsPageObject searchResultsPageObject = amazonHomePagePageObject.searchForItem("Lee Child");
        ProductPagePageObject productPagePageObject = searchResultsPageObject.findSpecficItemFromSearchResultsByTitle("Past Tense: (Jack Reacher 23)");

        assertThat("not on book product page", driver.getTitle(), containsString("Past Tense: (Jack Reacher 23)"));

        productPagePageObject.addSpecificItemToBasket();

        driver.findElement(By.cssSelector("#hlb-ptc-btn-native")).click();
        assertThat("check on signin page", driver.getTitle(), containsString("Sign In"));
    }

    @Test
    public void testSearchForJobsAndApply() {
        AmazonHomePagePageObject amazonHomePagePageObject = new AmazonHomePagePageObject(driver);
        AmazonCareersPagePageObject amazonCareersPagePageObject = amazonHomePagePageObject.clickOnCareers();
        JobListPageObject jobListPageObject = amazonCareersPagePageObject.searchforLocation("Lon");

        jobListPageObject.selectingJobCategory("Software Development");
        jobListPageObject.selectingDistance(5);
        jobListPageObject.selectingBusinessCategory("Prime Video");
        jobListPageObject.selectingJob("Software Development Engineer");
        jobListPageObject.applyingForJob();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

