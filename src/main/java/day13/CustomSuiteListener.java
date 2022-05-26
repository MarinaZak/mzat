package day13;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomSuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("CustomSuiteListener onStart");
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("CustomSuiteListener onFinish");
        ISuiteListener.super.onFinish(suite);
    }
}
