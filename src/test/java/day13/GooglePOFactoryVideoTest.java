package day13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import day12.GoogleBOFactory;
import day14.AllureListener;
import day14.DriverProvider;
import org.testng.annotations.*;


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
                .search("sonic 2022")
                .printSearchResult()
                .clickFirstResult()
                .validateURLHost();
    }

    @Test
    void googleFiledTest(){
        GoogleBOFactory googleBO=new GoogleBOFactory(DriverProvider.driver);
        googleBO
                .goToGoogle()
                .search("sonic 2022")
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
