package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	public static ChromeDriver driver;
	
	public void createLead() throws InterruptedException {

		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		String tabLinkTextLeads = "Leads";
		String btnLinkTextCreateLead = "Create Lead";
		String txtIdCompanyName = "createLeadForm_companyName";
		String txtIdFirstName = "createLeadForm_firstName";
		String txtIdLastName = "createLeadForm_lastName";
		String txtIdFirstNameLocal = "createLeadForm_firstNameLocal";
		String txtIdDepartment = "createLeadForm_departmentName";
		String txtIdDescription = "createLeadForm_description";
		String txtIdEmail = "createLeadForm_primaryEmail";
		String txtIdPhoneNumber = "createLeadForm_primaryPhoneNumber";
		String ddIdState = "createLeadForm_generalStateProvinceGeoId";
		String btnNameCreateLead = "submitButton";

		String url = "http://leaftaps.com/opentaps/control/login";
		String userName = "DemoSalesManager";
		String password = "crmsfa";
		String companyName = "New Company Name";
		String firstName = "Hello";
		String lastName = "World";
		String firstNameLocal = "Hello World";
		String department = "IT";
		String description = "Test Automation";
		String email = "hello.world@earth.com";
		String phoneNumber = "123456789";
		String state = "New York";
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
//		Assignment 1:Create Lead
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
//		  5. Click on Leads Button
		driver.findElement(By.linkText(tabLinkTextLeads)).click();
		
		Thread.sleep(3000);
		
//		  6. Click on Create Lead 
		driver.findElement(By.linkText(btnLinkTextCreateLead)).click();

//		  7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id(txtIdCompanyName)).sendKeys(companyName);
		
//		  8. Enter FirstName Field Using id Locator
		driver.findElement(By.id(txtIdFirstName)).sendKeys(firstName);
		
//		  9. Enter LastName Field Using id Locator
		driver.findElement(By.id(txtIdLastName)).sendKeys(lastName);
		
//		  10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id(txtIdFirstNameLocal)).sendKeys(firstNameLocal);
		
//		  11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id(txtIdDepartment)).sendKeys(department);
		
//		  12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id(txtIdDescription)).sendKeys(description);
		
//		  13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id(txtIdEmail)).sendKeys(email);
		
//		Enter phone number
		driver.findElement(By.id(txtIdPhoneNumber)).sendKeys(phoneNumber);
		
//		  14. Select State/Province as NewYork Using Visible Text
		WebElement eleState = driver.findElement(By.id(ddIdState));
		Select ddState = new Select(eleState);
		ddState.selectByVisibleText(state);
		
//		  15. Click on Create Button
		driver.findElement(By.name(btnNameCreateLead)).click();
		
//		  16. Get the Title of Resulting Page. refer the video using driver.getTitle()
		System.out.println("Page name after Lead Creation : " + driver.getTitle());
		
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		CreateLead createLead = new CreateLead();
		
		createLead.createLead();

		createLead.closeBrowser();
		
	}

}
