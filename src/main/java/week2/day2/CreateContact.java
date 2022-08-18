package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static ChromeDriver driver;
	
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
	
	
	public void createContact() {

		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		String btnLinkTextContacts = "Contacts";
		String tabLinkTextCreateContact = "Create Contact";
//		String txtIdCompanyName = "createLeadForm_companyName";
		String txtIdFirstName = "firstNameField";
		String txtIdLastName = "lastNameField";
		String txtIdFirstNameLocal = "createContactForm_firstNameLocal";
		String txtIdLastNameLocal = "createContactForm_lastNameLocal";
		String txtIdDepartment = "createContactForm_departmentName";
		String txtIdDescription = "createContactForm_description";
		String txtIdEmail = "createContactForm_primaryEmail";
		String ddIdState = "createContactForm_generalStateProvinceGeoId";
		String btnNameCreateContact = "submitButton";

		String userName = "DemoSalesManager";
		String password = "crmsfa";
		String companyName = "New Company Name";
		String firstName = "Hello";
		String lastName = "World";
		String firstNameLocal = "Hello First Local";
		String lastNameLocal = "Hello Last Local";
		String department = "IT";
		String description = "Test Automation";
		String email = "hello.world@earth.com";
		String state = "New York";
		
//		Assignment 1:Create Contact
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
//		  5. Click on contacts Button
		driver.findElement(By.linkText(btnLinkTextContacts)).click();
		
//		Thread.sleep(3000);
		
//		  6. Click on Create Contact
		driver.findElement(By.linkText(tabLinkTextCreateContact)).click();

//		  7. Enter CompanyName Field Using id Locator
//		driver.findElement(By.id(txtIdCompanyName)).sendKeys(companyName);
		
//		  7. Enter FirstName Field Using id Locator
		driver.findElement(By.id(txtIdFirstName)).sendKeys(firstName);

//		  8. Enter LastName Field Using id Locator
		driver.findElement(By.id(txtIdLastName)).sendKeys(lastName);
		
//		   9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id(txtIdFirstNameLocal)).sendKeys(firstNameLocal);
		
//		  10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id(txtIdLastNameLocal)).sendKeys(lastNameLocal);
		
//		  11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id(txtIdDepartment)).sendKeys(department);
		
//		  12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id(txtIdDescription)).sendKeys(description);
		
//		  13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id(txtIdEmail)).sendKeys(email);
		
//		  14. Select State/Province as NewYork Using Visible Text
		WebElement eleState = driver.findElement(By.id(ddIdState));
		Select ddState = new Select(eleState);
		ddState.selectByVisibleText(state);
		
//		  15. Click on Create Contact Button
		driver.findElement(By.name(btnNameCreateContact)).click();
		
//		  16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		System.out.println("Page name after Lead Creation : " + driver.getTitle());
		
	}
	
	public void editContact() {
		String lnkLinkTextEdit = "Edit";
		String tarIdDescription = "updateContactForm_description";
		String tarIdImportantNote = "updateContactForm_importantNote";
		String btnXpathUpdate = "//input[@value='Update']";
		
		String importantNote = "Do no disclose your credentials";
		
//		16. Click on edit button
		driver.findElement(By.linkText(lnkLinkTextEdit)).click();
		
//		 * 17. Clear the Description Field using .clear
		driver.findElement(By.id(tarIdDescription)).clear();

//		 * 18. Fill ImportantNote Field with Any text
		driver.findElement(By.id(tarIdImportantNote)).sendKeys(importantNote);

//		 * 19. Click on update button using Xpath locator
		driver.findElement(By.xpath(btnXpathUpdate)).click();

//		 * 20. Get the Title of Resulting Page.
		printTitle("Title after updating contact: ");
	}
	

	public static void main(String[] args) {

		String url = "http://leaftaps.com/opentaps/control/login";
		
		CreateContact contact = new CreateContact();
		contact.initializeDriver();
		contact.launchURL(url);
		contact.createContact();
		contact.editContact();
	}

}
