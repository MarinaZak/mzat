package day14;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import day12.GoogleBOFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(
        {UniversalVideoListener.class,
                AllureListener.class
        }
)
public class GooglePOFactoryVideoTest {


    @Test
    @Video
    void googleTest(){
        GoogleBOFactory googleBO=new GoogleBOFactory(DriverProvider.driver);
        googleBO
                .goToGoogle()
                .search("search Query Text")
                .printSearchResult()
                .clickFirstResult()
                .validateURLHost();
    }

    @Test
    void googleFiledTest(){
        GoogleBOFactory googleBO=new GoogleBOFactory(DriverProvider.driver);
        googleBO
                .goToGoogle()
                .search("search Query Text")
                .printSearchResult()
                .clickFirstResult()
                .validateURLHost()
                .failStep();
    }

    @AfterSuite
    void closeBrowser(){
        DriverProvider.driver.close();
        DriverProvider.driver.quit();
    }

}
