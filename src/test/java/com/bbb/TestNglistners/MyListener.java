package com.bbb.TestNglistners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import NinjaOpencart.NinjaPRoject.Login;

public class MyListener implements ITestListener
{
	ChromeDriver driver2=null;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("currently this test case is getting executed" +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("currently this test case got passed" +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("currently this test case got failed" +result.getName());
		File myScreenshot=((TakesScreenshot)Login.driver2).getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./Listenerscreenshots/Listenerfail.png");
		try {
			FileUtils.copyFile(myScreenshot,destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("currently this test case got skipped" +result.getName());
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("The execution of the test cases begins");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("currently this test case got skipped"); 
	}

}

