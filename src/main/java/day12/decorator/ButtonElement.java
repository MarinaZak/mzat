package day12.decorator;

import org.openqa.selenium.WebElement;

public class ButtonElement extends DecorElement{

    public ButtonElement(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.println("Try click ["+webElement.getAttribute("value")+"]");
        waitForMeVisible(3000L);
        webElement.click();
    }
}
