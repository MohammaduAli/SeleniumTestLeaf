package week4.day1;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import week2.day2.FindAndDuplicateLead;

public class AlertWindowMergeContact {

	public static ChromeDriver driver;
	String firstName;
	
	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions());
		
		maximizeBrowser();
		
		setImplicitWait();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void launchURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void closeAllBrowsers() {
		driver.quit();
	}
	
	public ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}
	
	public String getTitle() {

		return driver.getTitle();
		
	}

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
	public void verifyElementIsVisible(WebElement element, String elementName) {

		if(element.isDisplayed()) {
			System.out.println(elementName + " is visible");
		}else {
			System.out.println(elementName + " is not visible");
		}	
		
	}

	public void switchToFirstWindow() {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(0));
	}
	public void switchToSecondWindow() {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(1));
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cmaLogin() {

		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		
		String userName = "DemoSalesManager";
		String password = "crmsfa";
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
	}
	
	public void mergeContact() {
//		 * 5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
		 
//		 * 6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.xpath("//a[contains(text(), 'Merge Contacts')]")).click();
		 
//		 * 7. Click on Widget of From Contact
		 driver.findElement(By.xpath("//div[@jsid='partyIdFromComboBoxStore']/following-sibling::a")).click();

//		 * 8. Click on First Resulting Contact
		 switchToSecondWindow();
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		 
//		 * 9. Click on Widget of To Contact
		 switchToFirstWindow();
		 driver.findElement(By.xpath("//div[@jsid='partyIdToComboBoxStore']/following-sibling::a")).click();

//		 * 10. Click on Second Resulting Contact
		 switchToSecondWindow();
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		 
//		 * 11. Click on Merge button using Xpath Locator
		 switchToFirstWindow();
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		 
//		 * 12. Accept the Alert
		 acceptAlert();
		 
//		 * 13. Verify the title of the page
		 String pageTitle = driver.getTitle();
		 if (pageTitle.contains("View Contact")) {
			 
			System.out.println("Both the contacts have been merged");
			
		} else {

			System.out.println("Both the contacts are not merged");
			
		}
	}
	
	public static void main(String[] args) {

		String url = "http://leaftaps.com/opentaps/control/login";
		
		AlertWindowMergeContact alertMergeContact = new AlertWindowMergeContact();
		alertMergeContact.initializeDriver();
		alertMergeContact.launchURL(url);
		alertMergeContact.cmaLogin();
		alertMergeContact.mergeContact();
	}

}
