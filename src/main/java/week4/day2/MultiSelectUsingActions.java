package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectUsingActions {

	public static WebDriver driver;

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
	
	public void multiSelectPrograms() {
		
		String opXpathSelectProgram = "//select[@multiple]/option[text()='Select your programs']";
		String opXpathOption1 = opXpathSelectProgram.replace("Select your programs", "Selenium");
		String opXpathOption2 = opXpathSelectProgram.replace("Select your programs", "Loadrunner");
		
		WebElement eleToSelect1 = driver.findElement(By.xpath(opXpathOption1));
		WebElement eleToSelect2 = driver.findElement(By.xpath(opXpathOption2));
		
		verifyElementIsVisible(eleToSelect1, "Selenium");
		verifyElementIsVisible(eleToSelect2, "Loadrunner");		
		
		Actions builder = new Actions(driver);
		builder
			.keyDown(Keys.CONTROL)
			.click(eleToSelect1)
			.click(eleToSelect2)			
			.keyUp(Keys.CONTROL)
			.perform();
		
	}
	
	public static void main(String[] args) {
//		Classroom3: Done
//		http://leafground.com/pages/Dropdown.html
//		select "Selenium" and "Loadrunner" from the multi select combo box using actions

		String url = "http://leafground.com/pages/Dropdown.html";
		MultiSelectUsingActions multiSelectUsingActions = new MultiSelectUsingActions();
		multiSelectUsingActions.initializeDriver();
		multiSelectUsingActions.launchURL(url);
		multiSelectUsingActions.multiSelectPrograms();

	}

}
