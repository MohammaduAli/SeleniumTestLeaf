package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{

	public void editLeadAfterCreation() throws InterruptedException {
		String lnkLinkTextEdit = "Edit";
		String txtIdDescription = "updateLeadForm_description";
		String txtIdImportantNote = "updateLeadForm_importantNote";
		String btnXpathEdit = "//input[@value='Update']";

		String importantNote = "Keep this Lead ID confidential";

		Thread.sleep(3000);
		
		driver.findElement(By.linkText(lnkLinkTextEdit)).click();
		driver.findElement(By.id(txtIdDescription)).clear();
		driver.findElement(By.id(txtIdImportantNote)).sendKeys(importantNote);
		driver.findElement(By.xpath(btnXpathEdit)).click();

//		20. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		System.out.println("Page name after Editing Lead : " + driver.getTitle());
	}

	
	@Test
	public void EditLeadTest() throws InterruptedException {
//		CreateLead.main(null);
		
//		CreateLead createLead = new CreateLead();
//		createLead.createLead();
//		
//		driver = CreateLead.driver;
		
		EditLead editLead = new EditLead();
		editLead.editLeadAfterCreation();
		
		
	}

}
