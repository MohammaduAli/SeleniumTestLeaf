package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptAlert {

	public static WebDriver driver;

	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		maximizeBrowser();
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
	
	public void enterTextWithinAlertInsideFrame() {
//		Classroom 1:
//			1. Launch https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
//			2. Click on Try it
//			3. Enter the text on the alert and accept
//			4. Validate your name
		
		String nameToEnter = "Mohammadu Ali";

		driver.switchTo().frame("iframeResult");
		
		String btnXpathTryIt = "//button[text()='Try it']";
		driver.findElement(By.xpath(btnXpathTryIt)).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(nameToEnter);
		alert.accept();		

		String btnXpathDemoText = "//p[@id='demo']";
		String nameDisplayed = driver.findElement(By.xpath(btnXpathDemoText)).getText();
		
		if (nameDisplayed.contains(nameToEnter)) {
			System.out.println("Entered name '" + nameToEnter + "' inside Alert is successfully displayed inside frame");
		}
		else {
			System.out.println("Entered name '" + nameToEnter + "' and displayed name are not matching " + nameDisplayed);
		}
		
	}

	public static void main(String[] args) {

		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt";
		
		PromptAlert promptAlert = new PromptAlert();
		promptAlert.initializeDriver();
		promptAlert.launchURL(url);
		promptAlert.enterTextWithinAlertInsideFrame();
	}

}
