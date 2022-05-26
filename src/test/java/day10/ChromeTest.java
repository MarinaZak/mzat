package day10;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class ChromeTest {
    private WebDriver driver;

    @BeforeTest
    void initDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    void googleTest(){

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

    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}