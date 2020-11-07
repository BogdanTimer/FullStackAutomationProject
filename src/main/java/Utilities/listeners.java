package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener {

    public void onFinish(ITestContext execution) {
        System.out.println("---Finish execution---");
    }

    public void onStart(ITestContext execution) {
        System.out.println("---Starting execution---");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("---" + test.getName() + " skipped---");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---Starting test: " + test.getName() + "---");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---" + test.getName() + " passed---");
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---" + test.getName() + " failed---");
        if (!Platform.equalsIgnoreCase("api"))
            saveScreenshot();
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
