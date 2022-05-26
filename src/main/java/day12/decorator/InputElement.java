package day12.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends DecorElement{

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void input(String text) {
        System.out.println("Try input text : "+text);
        waitForMeVisible(3000L);
        webElement.sendKeys(text);
    }
}
