package day12;

import org.openqa.selenium.WebDriver;

public class ResultSearchPOFactory {
    private final WebDriver driver;

    public ResultSearchPOFactory(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
