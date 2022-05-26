package day13;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("CustomTestListener onTestStart");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("CustomTestListener onTestSuccess");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("CustomTestListener onTestFailure");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("CustomTestListener onStart");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("CustomTestListener onFinish");
        ITestListener.super.onFinish(context);
    }
}
