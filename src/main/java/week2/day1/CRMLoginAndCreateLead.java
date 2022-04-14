package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMLoginAndCreateLead {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Setup the Driver
		WebDriverManager.chromedriver().setup(); 
		
//		Other option: Setting system properties of ChromeDriver
//		System.setProperty("webdriver.chrome.driver", ".//chromedriver_win32//chromedriver.exe");

//		Launch the Browser
		ChromeDriver driver=new ChromeDriver(); 
		
//		Load the URL (get)
		driver.get("http://leaftaps.com/opentaps/control/main");
		 
//		Maximize the Browser Window
		driver.manage().window().maximize();
		
//		1. Login to application with the credential DemoSalesManager/crmsfa
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		2. Click on CRM/SFA
		String title = driver.getTitle();
		System.out.println(title);
		
//		3. Click on Leads
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		4. Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
//		5. Enter Manadatory fields
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("New Company Name");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("My First Name");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("My Last Name");

//		6. Select Employee from Source dropdown
		WebElement eleDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select ddSource = new Select(eleDropdown);
		ddSource.selectByVisibleText("Employee");
		
//		6. Click on Submit button
		driver.findElement(By.name("submitButton")).click();
		
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company created with name and id as following '" + companyName + "'");
		
		driver.close();
	}
}
