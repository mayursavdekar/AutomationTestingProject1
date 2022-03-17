/**
 * 
 */
package com.mayur.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.mayur.base.BasePage;

/**
 * @author Mayur
 *
 */
public class Listerner extends BasePage implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Your test is started :- " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss");
		String finalDateTime = dtf.format(dateTime);
		Reporter.log("Your test is success :- " + result.getMethod().getMethodName());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./testScerrenshots/passedTestCases/" + result.getMethod().getMethodName() + "" + finalDateTime+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LocalDateTime dateTime=LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter .ofPattern("dd|_MM_yyyy_hh_mm_ss");
		String finalDateTime=format.format(dateTime);
		Reporter.log("Your test is failed :- " + result.getMethod().getMethodName());
        File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination=new File ("./testScreenshots/failedTestCases/"+result.getMethod().getMethodName()+""+finalDateTime+".png");
        try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Your test is skipped :- " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("Your test is failed but within success percentage :- " + result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Your test is started :- " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Your test is finished :- " + context.getName());

	}

}
