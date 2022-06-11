package day11;
import day12.decorator.ButtonElement;
import day12.decorator.InputElement;
import day12.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginFailsPOFactory {

    private final WebDriver driver;

    @FindBy(xpath= "//*[@id='email']")
    private InputElement emailInput;

    @FindBy(xpath= "//*[@id='pass']")
    private InputElement passwordInput;

    @FindBy(name = "login")
    private ButtonElement login;


    public LoginFailsPOFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new MyFieldDecorator(driver),this);
        driver.get("https://www.facebook.com/");
    }

    public LoginFailsPOFactory inputData(String email, String password) {
        emailInput.input(email);
        passwordInput.input(password);
        return this;
    }

    public void login() {
        login.click();
    }

    public void goToProfile() {
        driver.get("https://www.facebook.com/me");
    }

    public void validateURL() {
        driver.get("https://www.facebook.com/me");
        String actualUrl=driver.getCurrentUrl();
        String loginUrl="https://www.facebook.com/";
        Assert.assertNotEquals(actualUrl, loginUrl, "invalid result URL");
    }
}
