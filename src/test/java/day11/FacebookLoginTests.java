package day11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class FacebookLoginTests {
    private WebDriver driver;

    @BeforeTest
    void initDriver(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    void loginFailsTest(){
        FacebookBOFactory facebookBO = new FacebookBOFactory(driver);
        facebookBO
                .goToFacebook()
                .login("+380502925208", "falsepassword")
                .goToProfile()
                .validateURL();
    }

    @Test
    void loginTest(){
        FacebookBOFactory facebookBO = new FacebookBOFactory(driver);
        facebookBO
                .goToFacebook()
                .login("+380502925208", "123testpassword")
                .goToProfile()
                .validateURL();
    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }

}
