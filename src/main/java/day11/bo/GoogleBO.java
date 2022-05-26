package day11.bo;

import day11.po.GoogleSearchPO;
import day11.po.ResultSearchPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class GoogleBO {
    private WebDriver driver;

    public GoogleBO(WebDriver driver) {
        this.driver=driver;
    }

    private GoogleSearchPO googleSearchPO;
    private ResultSearchPO resultSearchPO;

    public GoogleBO goToGoogle() {
        googleSearchPO=new GoogleSearchPO(driver);
        return this;
    }

    public GoogleBO search(String searchQueryText) {
        googleSearchPO.search(searchQueryText);
        return this;
    }

    public GoogleBO printSearchResult() {
        searchResultList= googleSearchPO.getResultList();
        searchResultList.forEach(e-> System.out.println(e.getText()+"\t"+e.getAttribute("href")));
        expectedURL= searchResultList.get(0).getAttribute("href");
        return this;
    }

    private List<WebElement> searchResultList;
    private String expectedURL;

    public GoogleBO clickFirstResult() {
        resultSearchPO = googleSearchPO.clickFirstResult();
        return this;
    }

    public void validateURL() {
        Assert.assertEquals(resultSearchPO.getUrl(),expectedURL,"invalid result URL");
    }
}
