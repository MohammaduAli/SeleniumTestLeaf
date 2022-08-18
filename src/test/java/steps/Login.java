package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass{
	
	@Given ("Enter username as DemoSalesManager")
	public void enterUserName() {

		String userName = "DemoSalesManager";

		String txtIdUserName = "username";
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		
	}
	
	@And ("Enter password as crmsfa")
	public void enterPassword() {
		
			String txtIdPassword = "password";
			String password = "crmsfa";
			driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
	}

	@When ("Click on login button")
	public void clickLogin() {

		String btnClassNameLogin = "decorativeSubmit";
		driver.findElement(By.className(btnClassNameLogin)).click();
		
	}

	@Then ("Home page should be displayed")
	public void verifyHomePage() {
		String expTitle = "Leaftaps - TestLeaf Automation Platform";
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(actTitle, expTitle);
		
	}
}
