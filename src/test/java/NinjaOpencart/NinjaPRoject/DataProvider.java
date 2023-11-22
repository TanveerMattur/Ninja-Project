package NinjaOpencart.NinjaPRoject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	
		@Test(dataProvider= "pleaseProvideTheData", dataProviderClass= DataProviderConcept.class)
			public void CheckLoginPage(String myEmail,String myPassword) throws InterruptedException
			{
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo");
			Thread.sleep(3000);
			WebElement myDropdown=driver.findElement(By.className("dropdown"));
			myDropdown.click();
			driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
			Thread.sleep(3000);			
			driver.findElement(By.id("input-email")).sendKeys(myEmail);
			driver.findElement(By.id("input-password")).sendKeys(myPassword);
			Thread.sleep(3000);			
			driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
				}
	}

