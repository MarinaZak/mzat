package day11;

import framework.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FacebookBOFactory {
    private WebDriver driver;

    public FacebookBOFactory(WebDriver driver) {
        this.driver=driver;
    }

    private LoginPOFactory loginPO;
    private LoginFailsPOFactory lfPO;

    @Step
    public FacebookBOFactory goToFacebook() {
        loginPO = new LoginPOFactory(driver);
        return this;
    }

    @Step
    public FacebookBOFactory login(String email, String password) {
        loginPO.inputData(email, password).login();
        return this;
    }

    @Step
    public FacebookBOFactory goToProfile() {
        loginPO.goToProfile();
        return this;
    }

    @Step
    public FacebookBOFactory validateURL() {
        loginPO.validateURL();
        return this;
    }
}
