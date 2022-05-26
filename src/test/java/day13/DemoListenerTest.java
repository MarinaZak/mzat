package day13;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomSuiteListener.class, CustomTestListener.class})
public class DemoListenerTest {

    @Test
    void testMethod(){
        Assert.assertTrue(true);
    }

    @Test
    void failedTestMethod(){
        Assert.assertTrue(false);
    }
}
