package NinjaOpencart.NinjaPRoject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {
	//@DataProvider(parallel=true)
	@DataProvider
	public Object[][] pleaseProvideTheData()
	{
		Object[][] mydata= {{"tanveermattur@.com","abcdef"},{"tanveermattur@.com","abcef"},{"tannumattur@.com","tannu@143"}};
		return mydata;
	}
}
