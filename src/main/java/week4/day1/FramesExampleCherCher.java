package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utilities.SeMethods;
import week3.day2.AjioWithList;

public class FramesExampleCherCher extends SeMethods{

	public static ChromeDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "https://chercher.tech/practice/frames-example-selenium-webdriver";
		
		FramesExampleCherCher framesExample = new FramesExampleCherCher();
		
		SeMethods.chromeSetup();
		
		initializeDriver();
		
//		1. Launch the URL https://www.ajio.com/
		launchURL(driver, url);
		switchToFrame(driver, "frame1");
		
//		Enter Text in TextField inside Frame1
		String txtXpathTopic = "//b[@id='topic']/following-sibling::input";
		String topic = "Sample Topic";
		driver.findElement(By.xpath(txtXpathTopic)).sendKeys(topic);
		
		String fieldText = driver.findElement(By.xpath(txtXpathTopic)).getAttribute("value");
		System.out.println(fieldText);
		
//		Select CheckBox inside Frame3
		switchToFrame(driver, "frame3");

		String chkIdInnerFrameCheckBox = "a";
		driver.findElement(By.id(chkIdInnerFrameCheckBox)).click();

		boolean selected = driver.findElement(By.id(chkIdInnerFrameCheckBox)).isSelected();

		System.out.println("Checkbox is selected: " + selected);
		
//		Select dropdown inside frame2

		switchToFrameDefault(driver);
		switchToFrame(driver, "frame2");

		String chkIdAnimals = "animals";
		String animalToSelect = "Baby Cat";
		WebElement ele = driver.findElement(By.id(chkIdAnimals));
		Select animals = new Select(ele);
		animals.selectByVisibleText(animalToSelect);

		WebElement firstSelectedOption = animals.getFirstSelectedOption();
		String selectedText = firstSelectedOption.getText();

		System.out.println("Selected option in dropdown : " + selectedText);
	}

	public static void initializeDriver() {
		driver = new ChromeDriver(SeMethods.chromeOptions());
		
		SeMethods.maximizeBrowser(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		SeMethods.setImplicitWait(driver);
	}
}
