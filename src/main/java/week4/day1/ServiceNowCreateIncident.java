package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.SeMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowCreateIncident extends SeMethods{

	String firstName;
	
	public void servicenowLogin() {

		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		
		String userName = "admin";
		String password = "crmsfa";
		
		String title = getTitle(driver);
		if (title.contains("Home")) {
			  
			  Shadow shadow = new Shadow(driver);
			  WebElement element = shadow.findElement("span[[class='dps-button-label']");
			  element.click();
//			  List<WebElement> element = shadow.findElements("paper-tab[title='Settings']");
//			  String text = element.getText();
//			driver.findElement(By.className(btnClassNameLogin)).click();
			
		}
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
	}
	
	public static void main(String[] args) {

//		String url = "https://developer.servicenow.com/";
		String url = "https://dev122476.service-now.com";

		chromeSetup();
		initializeDriver();
		launchURL(url);
		
		ServiceNowCreateIncident createIncident = new ServiceNowCreateIncident();
		createIncident.servicenowLogin();
//		createIncident.mergeContact();
	}

}
