package NinjaOpencart.NinjaPRoject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bbb.TestNglistners.MyListener;
@Listeners(MyListener.class)
public class FullProjectninja {
	ChromeDriver driver;
	@Test
     public void OpenBrowser() throws InterruptedException, IOException
	{
    FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\SELENIUM\\NinjaPRoject\\Ninjaaa.properties");
	
	Properties p=new Properties();
	p.load(fis);
	String myEmail=p.getProperty("Email");
	String myPassword=p.getProperty("Password");
	String myFirstname=p.getProperty("Firstname");
	String myLastname=p.getProperty("Lastname");
	String myEmail1=p.getProperty("Email1");
	String myPassword1=p.getProperty("Password1");
	String myTelephone=p.getProperty("Telephone");
	String myConfirm=p.getProperty("Confirm");
	
    driver=new ChromeDriver();
    driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo");
	Thread.sleep(2000);
	WebElement myDropdown=driver.findElement(By.className("dropdown"));
	myDropdown.click();
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
	Thread.sleep(2000);
    driver.findElement(By.id("input-email")).sendKeys(myEmail); 
	driver.findElement(By.id("input-password")).sendKeys(myPassword);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul/li[6]/a")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[1]/h4/a/i")).click();
	Thread.sleep(2000);
    WebElement myDropDown3=driver.findElement(By.id("input-country"));
	 Thread.sleep(3000);
	  myDropDown3.click();
	  Select s=new Select(myDropDown3);
	   s.selectByIndex(106);
	   
	   
	   WebElement myDropDown4=driver.findElement(By.id("input-zone"));
	   Thread.sleep(3000);
	   myDropDown4.click();
	   Select s4=new Select(myDropDown4);
	   s4.selectByIndex(15);
	   driver.findElement(By.id("input-postcode")).sendKeys("560043");
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//button[@id='button-quote']")).click();
	  
	  }
}
	

