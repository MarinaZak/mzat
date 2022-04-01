package day8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static day2.Calculator.*;

public class CalcTest {

    @DataProvider
    public static Object[][] addTestDataProvider(){
        Object[][] result = new Object[][]{
                {1,2},
                {4,0},
                {-1,5},
                {6,3}
        };
        return result;
    }

    @Test(dataProvider = "addTestDataProvider")
    void AddTest(Integer a, Integer b){
        Integer expected = a+b;
        Assert.assertEquals(add(a,b), expected, "invalid add operation");
    }

    @Test(dataProvider = "addTestDataProvider")
    void MinusTest(Integer a, Integer b){
        Integer expected = a-b;
        Assert.assertEquals(minus(a,b), expected, "invalid subtraction operation");
    }

    @Test(dataProvider = "addTestDataProvider")
    void MultTest(Integer a, Integer b){
        Integer expected = a*b;
        Assert.assertEquals(mult(a,b), expected, "invalid multiply operation");
    }

    @Test(dataProvider = "addTestDataProvider")
    void DivideTest(Integer a, Integer b){
        Integer expected = a/b;
        Assert.assertEquals(divide(a,b), expected, "invalid divide operation");
    }

}
