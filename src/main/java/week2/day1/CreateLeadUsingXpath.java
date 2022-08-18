package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadUsingXpath {

	public static void main(String[] args) {

		String txtXpathUserName = "//input[@id='username']";
		String txtXpathPassword = "//input[@id='password']";
		String btnXpathLogin = "//input[@class='decorativeSubmit'][@value='Login']";
		String lnkXpathCRMSFA = "//a[contains(text(), 'CRM/SFA')]";
		String tabXpathLeads = "//a[text()='Leads']";
		String lnkXpathCreateLead = "//a[text()='Create Lead']";
		String txtXpathCompanyName = "//input[@id='createLeadForm_companyName']";
		String txtXpathFirstName = "//input[@id='createLeadForm_firstName']";
		String txtXpathLastName = "//input[@id='createLeadForm_lastName']";
		String txtXpathFirstNameLocal = "//input[@id='createLeadForm_firstNameLocal']";
		String txtXpathDepartment = "//input[@id='createLeadForm_departmentName']";
		String txtXpathDescription = "//textarea[@id='createLeadForm_description']";
		String txtXpathEmail = "//input[@id='createLeadForm_primaryEmail']";
		String ddXpathState = "//select[@id='createLeadForm_generalStateProvinceGeoId']";
		String btnXpathCreateLead = "//input[@name='submitButton']";

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
		String state = "New York";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		
		
//		Assignment 1:Create Lead
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath(txtXpathUserName)).sendKeys(userName);
		driver.findElement(By.xpath(txtXpathPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.xpath(btnXpathLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.xpath(lnkXpathCRMSFA)).click();
		
//		  5. Click on Leads Button
		driver.findElement(By.xpath(tabXpathLeads)).click();
		
//		Thread.sleep(3000);
		
//		  6. Click on Create Lead 
		driver.findElement(By.xpath(lnkXpathCreateLead)).click();

//		  7. Enter CompanyName Field Using id Locator
		driver.findElement(By.xpath(txtXpathCompanyName)).sendKeys(companyName);
		
//		  8. Enter FirstName Field Using id Locator
		driver.findElement(By.xpath(txtXpathFirstName)).sendKeys(firstName);
		
//		  9. Enter LastName Field Using id Locator
		driver.findElement(By.xpath(txtXpathLastName)).sendKeys(lastName);
		
//		  10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.xpath(txtXpathFirstNameLocal)).sendKeys(firstNameLocal);
		
//		  11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath(txtXpathDepartment)).sendKeys(department);
		
//		  12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.xpath(txtXpathDescription)).sendKeys(description);
		
//		  13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.xpath(txtXpathEmail)).sendKeys(email);
		
//		  14. Select State/Province as NewYork Using Visible Text
		WebElement eleState = driver.findElement(By.xpath(ddXpathState));
		Select ddState = new Select(eleState);
		ddState.selectByVisibleText(state);
		
//		  15. Click on Create Button
		driver.findElement(By.xpath(btnXpathCreateLead)).click();
		
//		  16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
