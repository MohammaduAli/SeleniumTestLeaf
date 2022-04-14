package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIPathLogin {

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

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void uiPathLoginAndLogout() {
		String email = "kumar.testleaf@gmail.com";
		String password = "leaf@12";
		
		String txtIDEmail = "email";
		String txtIDPassword = "password";
		String btnXpathLogin ="//button[contains(text(), 'Login')]";
		String lnkLinkTextLogOut = "Log Out";
		
		driver.findElement(By.id(txtIDEmail)).sendKeys(email);
		driver.findElement(By.id(txtIDPassword)).sendKeys(password);
		driver.findElement(By.xpath(btnXpathLogin)).click();
		
		printTitle("Logged in successfully and page title is ");
		
		driver.findElement(By.linkText(lnkLinkTextLogOut)).click();
		
		closeBrowser();
		
	}
	
	public static void main(String[] args) {

		String url = "https://acme-test.uipath.com/login";
		
		UIPathLogin uiPathLogin = new UIPathLogin();
		uiPathLogin.initializeDriver();
		uiPathLogin.launchURL(url);
		uiPathLogin.maximizeBrowser();
		uiPathLogin.uiPathLoginAndLogout();		
		
	}

}
