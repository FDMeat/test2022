package pages;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DetailsPage {
    private static WebDriver driver;

    @FindBy(css = "#rhs div[data-attrid*='poslednyaya_versiya'] .LrzXr.kno-fv.wHYlTd.z8gr9e")
    private List<WebElement> lastVersion;

    @FindBy(css = "#rhs div[data-attrid*='licenziya'] .LrzXr.kno-fv.wHYlTd.z8gr9e")
    private List<WebElement> license;

    public DetailsPage(WebDriver driver) {
        initElements(driver, this);
    }

}

