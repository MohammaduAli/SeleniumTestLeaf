package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAndDuplicateLead {

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
	
	public void findLeadByEmail() throws InterruptedException {
		String tabLinkTextLeads = "Leads";
		String menuLinkTextFindLeads = "Find Leads";
		String tabXpathEmail = "//span[text()='Email']";
		String txtNameEmail = "emailAddress";
		String btnXpathFindLeads = "//button[text()='Find Leads']";
		String lblXpathFirstLeadName = "(//div[contains(@class,'-col-firstName')])[1]/a";
		
		String email = "hello.world@earth.com";
		
//		6	Click Leads link
		driver.findElement(By.linkText(tabLinkTextLeads)).click();
		
//		7	Click Find leads
		driver.findElement(By.linkText(menuLinkTextFindLeads)).click();
		
//		8	Click on Email
		driver.findElement(By.xpath(tabXpathEmail)).click();
		
//		9	Enter Email
		driver.findElement(By.name(txtNameEmail)).sendKeys(email);;
		
//		10	Click find leads button
		driver.findElement(By.xpath(btnXpathFindLeads)).click();
		
		Thread.sleep(2000); //Without this statement, it would lead to staleElementException
		
//		11	Capture name of First Resulting lead
		firstName = driver.findElement(By.xpath(lblXpathFirstLeadName)).getText();
		System.out.println("First lead name is '" + firstName + "'");
		
//		12	Click First Resulting lead
		driver.findElement(By.xpath(lblXpathFirstLeadName)).click();
	}
	
	public void duplicateLead() {

		String lnkLinkTextDuplicateLead = "Duplicate Lead";
		String btnXpathCreateLead = "//input[@value='Create Lead']";
		String lblIDFirstName = "viewLead_firstName_sp";
		
		String firstNameAfterDuplicate;
		
//		13	Click Duplicate Lead
		driver.findElement(By.linkText(lnkLinkTextDuplicateLead)).click();
		
//		14	Verify the title as 'Duplicate Lead'
		String title = getTitle();
		if (title.contains("Duplicate Lead")) {
			
			System.out.println("Navigated to Duplicate Lead page successfully");
			
		}else {

			System.out.println("User not navigated to Duplicate Lead page");
			
		}
		
//		15	Click Create Lead
		driver.findElement(By.xpath(btnXpathCreateLead)).click();
		
//		16	Confirm the duplicated lead name is same as captured name
		firstNameAfterDuplicate = driver.findElement(By.id(lblIDFirstName)).getText();
		if (firstName.equals(firstNameAfterDuplicate)) {
			
			System.out.println("First name before and after lead duplicate are matching");
			
		} else {
			
			System.out.println("First name before and after lead duplicate are not matching");

		}
		
//		17	Close the browser (Do not log out)
		closeAllBrowsers();
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		String url = "http://leaftaps.com/opentaps/control/login";
		
		FindAndDuplicateLead findAndDuplicateLead = new FindAndDuplicateLead();
		findAndDuplicateLead.initializeDriver();
		findAndDuplicateLead.launchURL(url);
		findAndDuplicateLead.cmaLogin();
		findAndDuplicateLead.findLeadByEmail();
		findAndDuplicateLead.duplicateLead();
	}

}
