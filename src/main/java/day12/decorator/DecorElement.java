package day12.decorator;

import org.openqa.selenium.WebElement;

import java.util.Date;

public class DecorElement {
    WebElement webElement;

    public DecorElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMeVisible(Long timeoutInMS) {
        long start=new Date().getTime();
        while(
                !webElement.isDisplayed()
                && new Date().getTime()-start<timeoutInMS
        ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait for "+webElement);
        }
    }
}
