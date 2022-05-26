package day11.po;

import org.openqa.selenium.WebDriver;

public class ResultSearchPO {
    private final WebDriver driver;

    public ResultSearchPO(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
