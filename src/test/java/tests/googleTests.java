package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage detailsPage;


    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }
        @Test
        public void test1() {
            driver.get("http://google.com");
            searchPage.search("selenium");
            assertEquals(12, searchPage.results.size());
    }
        @Test
            public void test2() {
                driver.get("http://google.com");
                searchPage.search("selenium");
                assertEquals("3.141.59 (14 ноября 2018 года)", detailsPage.getLastVersion());
                assertEquals("Apache License 2.0", detailsPage.getLicense());
        }

        @AfterAll
    public static void teardown(){
        driver.quit();

    }
}
