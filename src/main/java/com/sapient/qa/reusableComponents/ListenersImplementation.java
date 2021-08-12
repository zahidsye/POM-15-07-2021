package com.sapient.qa.reusableComponents;

import com.aventstack.extentreports.Status;
import com.sapient.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenersImplementation extends ObjectsRepo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        //test = extent.createTest(result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getDescription());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case: " + result.getMethod().getDescription() + " is Passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case: " + result.getMethod().getDescription() + " is Failed.");
        test.log(Status.FAIL, result.getThrowable());

        //add screenshot for failed test.
        File src = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String screenshotPath = System.getProperty("user.dir") +
                "/target/Screenshots/" + actualDate + ".jpeg";
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String screenshotsPath2 = "./screenshots/" + dest.getName();
        try {
            test.addScreenCaptureFromPath(screenshotsPath2, "Test case failure screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentSetup.setupExtentReport();

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}
