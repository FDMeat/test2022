package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.getKeyFromUnicode;

public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
    }
        @Test
        public void test1() {
            driver.get("http://google.com");
            searchPage.search("selenium");
            assertEquals(12, searchPage.results.size());
        }

        @Test
        public void test2() throws InterruptedException {
        driver.get("http://google.com");
        searchPage.search("Калькулятор");
        driver.findElement(By.cssSelector("#rso .TIGsTb")).click();
        driver.findElement(By.cssSelector("#rso .jlkklc")).sendKeys("(1+2)×3-40/5=",ENTER);
        Thread.sleep(1000);
        }

    @Test
    public void test3() throws InterruptedException {
        driver.get("http://google.com");
        searchPage.search("Калькулятор");
        driver.findElement(By.cssSelector("#rso .TIGsTb")).click();
        driver.findElement(By.cssSelector("#rso .jlkklc")).sendKeys("6/0=",ENTER);
        Thread.sleep(1000);
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("http://google.com");
        searchPage.search("Калькулятор");
        driver.findElement(By.cssSelector("#rso div[jsname*='aN1RFf']")).click();
        driver.findElement(By.cssSelector("#rso .jlkklc")).sendKeys("=");
        Thread.sleep(1000);
    }

    @AfterAll
    public static void teardown(){
        driver.quit();

    }
}
