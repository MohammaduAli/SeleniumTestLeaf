package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderCreateLead extends BaseClass{

	@Test(dataProvider="LeadData")
	public void createLead(String companyName, String firstName, String lastName, String firstNameLocal, String department, String description, String email, String phoneNumber, String state) throws InterruptedException {

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

	@DataProvider(name="LeadData")
	public String[][] leadData() {
		String[][] data = new String [2][9];

		data[0][0] = "New Company Name 1";
		data[0][1] = "Hello 1";
		data[0][2] = "World 1";
		data[0][3] = "Hello World 1";
		data[0][4] = "IT 1";
		data[0][5] = "Test Automation 1";
		data[0][6] = "hello.world1@earth.com";
		data[0][7] = "12345678901";
		data[0][8] = "New York";

		data[1][0] = "New Company Name 2";
		data[1][1] = "Hello 2";
		data[1][2] = "World 2";
		data[1][3] = "Hello World 2";
		data[1][4] = "IT 2";
		data[1][5] = "Test Automation 2";
		data[1][6] = "hello.world2@earth.com";
		data[1][7] = "12345678902";
		data[1][8] = "New York";
		
		return data;
	}
	
	public void createLeadTest(String companyName, String firstName, String lastName, String firstNameLocal, String department, String description, String email, String phoneNumber, String state) throws InterruptedException {
//		createLead();
		
	}

}
