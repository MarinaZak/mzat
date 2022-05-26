package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverProvider {

    public static WebDriver driver=initDriver();

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver","driver"+ File.separator+"chromedriver");
        driver = new ChromeDriver();
        return driver;
    }
}
