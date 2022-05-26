package day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        //initFromScratch();
        initUsingDriverManager();
        driver.get("https://www.google.com.ua/imghp?hl=ru&ogbl");

        WebElement searchInput=driver.findElement(By.name("q"));
        String searchQueryText="sonic movie 2022";
        searchInput.sendKeys(searchQueryText +Keys.ENTER
                //'\ue007'
        );

        List<WebElement> searchResultList= driver.findElements(By.xpath("//div[@id=\"islrg\"]/div/div/a"));
        List<WebElement> searchResultList2= driver.findElements(By.xpath("//div[@id=\"islrg\"]/div/div"));
        searchResultList.forEach(e-> System.out.println(e.getText()+"\t"+e.getAttribute("href")));
        String expectedURL= searchResultList.get(0).getAttribute("href");
        String expectedURL2= driver.getCurrentUrl()+"#imgrc="+searchResultList2.get(0).getAttribute("data-id");

        searchResultList.get(0).click();

        String actualURL= driver.getCurrentUrl();

//        Assert.assertEquals(actualURL, expectedURL2, "invalid result URL");
        Assert.assertEquals(actualURL, expectedURL, "invalid result URL");


        driver.close();
        driver.quit();
    }

    private static void initUsingDriverManager() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    private static void initFromScratch() {

        System.setProperty("webdriver.chrome.driver","driver"+ File.separator+"chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.close();
        driver.quit();
    }
}