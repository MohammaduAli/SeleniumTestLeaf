package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	public static WebDriver driver;

	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	
	public void launchURL(String url) {
		driver.get(url);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void userRegistration() throws InterruptedException {
		String url = "https://en-gb.facebook.com/";
		
		
		// Step 1: Download and set the path
		initializeDriver();
		
		// Step 2: Launch the chrome browser		
		// Step 3: Load the URL https://en-gb.facebook.com/
		launchURL(url);

		// Step 4: Maximize the window
		maximizeBrowser();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.wait();
		
		// Step 6: Click on Create New Account button
		String lnkLinkTextCreateAccount = "Create New Account";
		driver.findElement(By.linkText(lnkLinkTextCreateAccount)).click();
		
		String txtNameFirstName = "firstname";
		String txtNameLastName = "lastname";
		String txtNameMobileOrEmail = "reg_email__";
		String txtIDPassword = "password_step_input";
		String ddIDDOBDay = "day";
		String ddIDDOBMonth = "month";
		String ddIDDOBYear = "year";
		String rdoXpathGenderFemale = "//span[@data-name='gender_wrapper']//label[text()='Female']";
		String rdoXpathGenderMale = "//span[@data-name='gender_wrapper']//label[text()='Male']";
		String rdoXpathGenderCustom = "//span[@data-name='gender_wrapper']//label[text()='Custom']";
		
		String firstName = "hello";
		String lastName = "world";
		String mobile = "9997778881";
		String password = "Optimistic";
		String birthDay = "18";
		String birthMonth = "Jan";
		String birthYear = "1990";
		

		// Step 7: Enter the first name
		driver.findElement(By.name(txtNameFirstName)).sendKeys(firstName);
		
		// Step 8: Enter the last name
		driver.findElement(By.name(txtNameLastName)).sendKeys(lastName);
		
		// Step 9: Enter the mobile number
		driver.findElement(By.name(txtNameMobileOrEmail)).sendKeys(mobile);
		
		// Step 10: Enter the password
		driver.findElement(By.id(txtIDPassword)).sendKeys(password);
		
		// Step 11: Handle all the three drop downs
		WebElement eleDay = driver.findElement(By.id(ddIDDOBDay));
		WebElement eleMonth = driver.findElement(By.id(ddIDDOBMonth));
		WebElement eleYear = driver.findElement(By.id(ddIDDOBYear));
		Select ddDay = new Select(eleDay);
		Select ddMonth = new Select(eleMonth);
		Select ddYear = new Select(eleYear);
		ddDay.selectByVisibleText(birthDay);
		ddMonth.selectByVisibleText(birthMonth);
		ddYear.selectByVisibleText(birthYear);
		
		// Step 12: Select the radio button "Female"
		// ( A normal click will do for this step) 
		driver.findElement(By.xpath(rdoXpathGenderFemale)).click();

	}

	
	public static void main(String[] args) throws InterruptedException {
		String url = "https://en-gb.facebook.com/";
		
		Facebook facebook = new Facebook();
		facebook.userRegistration();
//		facebook.closeBrowser();

	}

}
