package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	
	@BeforeTest
	public void preCondition() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
//		Assignment 1:Create Lead
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"

		String url = "http://leaftaps.com/opentaps/control/login";
		String userName = "DemoSalesManager";
		String password = "crmsfa";

		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
	}
	
	@AfterTest
	public void postCondition() {
		closeAllBrowser();
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}
}
