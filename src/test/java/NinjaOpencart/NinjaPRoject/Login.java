package NinjaOpencart.NinjaPRoject;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Login 
{
    ExtentReports extentReport;
   public static ChromeDriver driver2;
	@BeforeTest
	public void CreateReport()
	{
		
		extentReport = new ExtentReports();
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./reports/Report.html");
		extentReport.attachReporter(extentSparkReporter);
	}
	@AfterTest
	public void actuallyCreateReport()
	{
		extentReport.flush();
	}
	@Test
	public void CheckLoginWithValidData()throws InterruptedException 
	{
		ExtentTest extentTest =extentReport.createTest("Opencart login check","this test case checks the login page with" + "valid data");
		extentTest.assignAuthor("Sagar G");
		extentTest.assignAuthor("windows Chrome 114");
		extentTest.assignCategory("Functional Testing");
		
		extentTest.log(Status.INFO,"chrome browser will get opened");
		ChromeDriver driver=new ChromeDriver();
		extentTest.log(Status.PASS,"Chrome browser got opened");
		driver.get("https://tutorialsninja.com/demo");
		Thread.sleep(3000);
		extentTest.log(Status.INFO,"Url got opened");
		WebElement myDropdown=driver.findElement(By.className("dropdown"));
		extentTest.log(Status.PASS,"Dropdown got opened");
		myDropdown.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
		extentTest.log(Status.PASS,"login is selected from the dropdown");
		Thread.sleep(3000);
		
		try {
			extentTest.log(Status.INFO,"Email and password will be entered");
			driver.findElement(By.id("input-email")).sendKeys("shyamsundar456789@gmail.com");
			driver.findElement(By.id("input-password")).sendKeys("shyam@321");
			extentTest.log(Status.PASS,"Email and password is entered");
		}
		catch(NoSuchElementException e)
		{
			extentTest.log(Status.FAIL,"password couldnot be located");
		}
		
		Thread.sleep(3000);
		extentTest.log(Status.PASS,"Password is entered");
		extentTest.log(Status.INFO,"login will be clicked");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		extentTest.log(Status.PASS,"login button is clicked");
		Thread.sleep(3000);
		extentTest.log(Status.PASS,"Broswer got closed");
		driver.close();
		
	}
        @Test(priority=1)
		public void OpencartQuickSearch() throws IOException
		{
			ExtentTest extentTest2 =extentReport.createTest("Opencart login check","this test case checks the login page with" + "invalid data");
			extentTest2.assignAuthor("Sundar");
			extentTest2.assignAuthor("windows 10 Chrome 114");
			extentTest2.assignCategory("Functional Testing");
			
			try {
				extentTest2.log(Status.INFO,"hello my world");
				driver2=new ChromeDriver();
				driver2.get("https://tutorialsninja.com/demo");
				WebElement myDropdown=driver2.findElement(By.className("dropdown"));
				myDropdown.click();
				driver2.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
				
				driver2.findElement(By.id("input-emal")).sendKeys("shyamsundar456789@gmail.com");
				driver2.findElement(By.id("input-password")).sendKeys("shyam@321");
				driver2.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
			
				extentTest2.log(Status.PASS,"------");
			}
	catch(NoSuchElementException e)
			{
		extentTest2.log(Status.FAIL,"Above element is not located");
			}
			
			File myScreenshot=((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("./screenshots/fail.png");
			FileUtils.copyFile(myScreenshot,destinationFile);
		}	
	}
