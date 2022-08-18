package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{

	public void duplicateLeadAfterCreation() throws InterruptedException {
		String lnkLinkTextDuplicateLead = "Duplicate Lead";
		String txtIdCompanyName = "createLeadForm_companyName";
		String txtIDFirstName = "createLeadForm_firstNameLocal";
		String btnXpathCreateLead = "//input[@value='Create Lead']";
		
		String newCompanyName = "Another Company Name";
		String newFirstName = "Hello Earth";

		Thread.sleep(3000);
		
//		17. Click on Duplicate button
		driver.findElement(By.linkText(lnkLinkTextDuplicateLead)).click();
		
//		18. Clear the CompanyName Field using .clear() And Enter new CompanyName
		driver.findElement(By.id(txtIdCompanyName)).clear();
		driver.findElement(By.id(txtIdCompanyName)).sendKeys(newCompanyName);
		
//		19.Clear the FirstName Field using .clear() And Enter new FirstName
		driver.findElement(By.id(txtIDFirstName)).clear();
		driver.findElement(By.id(txtIDFirstName)).sendKeys(newFirstName);
		
//		20.Click on Create Lead Button
		driver.findElement(By.xpath(btnXpathCreateLead)).click();;
		
//		21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		System.out.println("Page name after Duplicating Lead : " + driver.getTitle());

	}

	@Test
	public void DeleteLeadTest() throws InterruptedException {
		
//		CreateLead.main(null);
		
//		CreateLead createLead = new CreateLead();
//		createLead.createLead();
//		
//		driver = CreateLead.driver;
		
		DuplicateLead duplicateLead = new DuplicateLead();
		duplicateLead.duplicateLeadAfterCreation();
		
		
	}

}
