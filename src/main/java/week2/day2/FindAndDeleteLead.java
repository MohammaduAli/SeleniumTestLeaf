import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAndDeleteLead {

	public static ChromeDriver driver;
	String leadID;
	
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
	
	public boolean isElementPresent(By selector){

		return driver.findElements(selector).size()>0;
		
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

	public void navigateToCreateLead() {
		String tabLinkTextLeads = "Leads";
		String btnLinkTextCreateLead = "Create Lead";
		
//		  5. Click on Leads Button
		driver.findElement(By.linkText(tabLinkTextLeads)).click();

//		  6. Click on Create Lead 
		driver.findElement(By.linkText(btnLinkTextCreateLead)).click();

	}
	
	public void navigateToFindLeads() {
		String tabLinkTextLeads = "Leads";
		String menuLinkTextFindLeads = "Find Leads";
		
//		  5. Click on Leads Button
		driver.findElement(By.linkText(tabLinkTextLeads)).click();
		
		driver.findElement(By.linkText(menuLinkTextFindLeads)).click();
		
	}
	
	public void createLead() throws InterruptedException {

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

//		  5. Click on Leads Button
//		  6. Click on Create Lead 
		navigateToCreateLead();
		
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
		
//		  16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		System.out.println("Page name after Lead Creation : " + driver.getTitle());
		
	}
	
	public void findLeadByPhone() throws InterruptedException {
		String tabLinkTextLeads = "Leads";
		String tabXpathPhone = "//span[text()='Phone']";
		String txtNamePhone = "phoneNumber";
		String btnXpathFindLeads = "//button[text()='Find Leads']";
		String lblXpathLeadId = "(//div[contains(@class,'-col-partyId')])[1]/a";
		
		String phoneNumber = "123456789";
		
//		6	Click Leads link
		driver.findElement(By.linkText(tabLinkTextLeads)).click();

//		7	Click Find leads
		navigateToFindLeads();
		
//		8	Click on Phone
		driver.findElement(By.xpath(tabXpathPhone)).click();
		
//		9	Enter phone number
		driver.findElement(By.name(txtNamePhone)).sendKeys(phoneNumber);
		
//		10	Click find leads button
		driver.findElement(By.xpath(btnXpathFindLeads)).click();

		Thread.sleep(2000); //Without this statement, it would lead to staleElementException
		
//		11	Capture lead ID of First Resulting lead
		leadID = driver.findElement(By.xpath(lblXpathLeadId)).getText();
		System.out.println("Lead ID is '" + leadID + "'");
				
//		12	Click First Resulting lead
		driver.findElement(By.xpath(lblXpathLeadId)).click();
	}
	
	public void deleteLeadAndVerify() throws InterruptedException {
		String btnLinkTextDelete = "Delete";
		String txtNameLeadId = "id";
		String btnXpathFindLeads = "//button[text()='Find Leads']";
		String lblXpathNoRecordsFound = "//div[text()='No records to display']";
		
//		13	Click Delete
		driver.findElement(By.linkText(btnLinkTextDelete)).click();
		
//		14	Click Find leads
		navigateToFindLeads();
		
//		15	Enter captured lead ID
		driver.findElement(By.name(txtNameLeadId)).sendKeys(leadID);
		
//		16	Click find leads button
		driver.findElement(By.xpath(btnXpathFindLeads)).click();

		Thread.sleep(2000); //Without this statement, it would lead to staleElementException
		
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
//		WebElement eleNoRecordsFound = driver.findElement(By.xpath(lblXpathNoRecordsFound));
		
		if (isElementPresent(By.xpath(lblXpathNoRecordsFound))) {
			
			System.out.println("Lead with Id '" + leadID + "' was successfully deleted");
			
		} else {

			System.out.println("Lead with Id '" + leadID + "' was not deleted");
			
		}
		
//		18	Close the browser (Do not log out)
		closeAllBrowsers();
	}
	
	public static void main(String[] args) throws InterruptedException {

		String url = "http://leaftaps.com/opentaps/control/login";
		
		FindAndDeleteLead findAndDeleteLead = new FindAndDeleteLead();
		findAndDeleteLead.initializeDriver();
		findAndDeleteLead.launchURL(url);
		findAndDeleteLead.cmaLogin();
		findAndDeleteLead.createLead();
		findAndDeleteLead.findLeadByPhone();
		findAndDeleteLead.deleteLeadAndVerify();
		
	}

}
