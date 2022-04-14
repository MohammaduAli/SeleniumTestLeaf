package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowNavigation {

	public static WebDriver driver;

	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		maximizeBrowser();
		
		setImplicitWait();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void launchURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void irctcWindow() {
//			1. Navigate to https://www.irctc.co.in/
//			2. Click Ok in the alert
			String btnXpathOK = "//button[@class='btn btn-primary']";
			driver.findElement(By.xpath(btnXpathOK)).click();
		
//			3. Click on FLIGHTS link
			String lnkLinkTextFlights = "FLIGHTS";
			driver.findElement(By.linkText(lnkLinkTextFlights)).click();
			
//			4. Switch to the Flights window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> listHandles = new ArrayList<String>();
			listHandles.addAll(windowHandles);
			driver.switchTo().window(listHandles.get(1));
			
//			5. Print the Title of the Flights window
			printTitle("Flight Window title is : ");
			
//			6. Close the Flights window alone
			driver.close();
			
//			7. Print the Train search window title (First window)
			driver.switchTo().window(listHandles.get(0));
			printTitle("Train Window title is : ");
	}

	public static void main(String[] args) {

		String url = "https://www.irctc.co.in/";
		
		WindowNavigation windowNavigation = new WindowNavigation();
		windowNavigation.initializeDriver();
		windowNavigation.launchURL(url);
		windowNavigation.irctcWindow();
	}

}
