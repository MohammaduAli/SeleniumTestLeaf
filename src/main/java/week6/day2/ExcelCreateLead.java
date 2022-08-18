package week6.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelCreateLead extends BaseClass{

	@BeforeTest
	void setExcelFileName() {
		excelFileName = "CreateLead";
	}

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
	public String[][] leadData() throws IOException {
		
		return readExcel(excelFileName);
				
	}
	
}
