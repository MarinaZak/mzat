package day11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPO {
   private final WebDriver driver;

    public GoogleSearchPO(WebDriver driver) {
        this.driver=driver;
        driver.get("https://www.google.com/");
    }

    public void search(String searchQueryText) {
        driver.findElement(By.name("q")).sendKeys(searchQueryText + Keys.ENTER);
    }

    public List<WebElement> getResultList() {
        return driver.findElements(By.xpath("//div[@id=\"rso\"]/div/div/div/div/a"));
    }

    public ResultSearchPO clickFirstResult() {
        getResultList().get(0).click();
        return new ResultSearchPO(driver);
    }
}
