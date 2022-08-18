package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.SeMethods;

public class AjioWithList {

	public static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.ajio.com/";
		
		AjioWithList ajioWithList = new AjioWithList();
		
		SeMethods.chromeSetup();
		
		initializeDriver();
		
//		1. Launch the URL https://www.ajio.com/
		SeMethods.launchURL(driver, url);
		
//		2. In the search box, type as "bags" and press enter
		ajioWithList.searchItem("Bags");
		
//		3. To the left of the screen under " Gender" click the "Men"
		ajioWithList.selectGender("Men");
		
//		4. Under "Category" click "Fashion Bags"
		ajioWithList.selectCategory("Fashion Bags");
		
//		5. Print the count of the items Found. 
		ajioWithList.printItemsCount();
		
//		6. Get the list of brand of the products displayed in the page and print the list.
		ajioWithList.printBrandOfEachProductDisplayed();
		
//		7. Get the list of names of the bags and print it
		ajioWithList.printNameOfBags();

	}

	public static void initializeDriver() {
		driver = new ChromeDriver(SeMethods.chromeOptions());
		
		SeMethods.maximizeBrowser(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		SeMethods.setImplicitWait(driver);
	}
	
	public void searchItem(String searchValue) {
		String txtNameSearch = "searchVal";
		String btnClassNameSearch = "ic-search";
		
		driver.findElement(By.name(txtNameSearch)).sendKeys(searchValue);
		driver.findElement(By.className(btnClassNameSearch)).click();
	}

	public void selectGender(String gender) throws InterruptedException {
		
		String chkXpathGender = "//input[@id='" + gender +"']/parent::div"; 
		driver.findElement(By.xpath(chkXpathGender)).click();
		
//		String chkIdGender = gender;
//		WebElement ele = driver.findElement(By.id("Men"));		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();  
	}

	public void selectCategory(String categoryName) throws InterruptedException {
		
		String chkXpathCategory = "//input[contains(@id,'" + categoryName + "')]/following-sibling::label";
//		driver.findElement(By.xpath(chkXpathCategory)).click();
		WebElement ele = driver.findElement(By.xpath(chkXpathCategory));	

//		To avoid 'stale element reference: element is not attached to the page document' exception
		Thread.sleep(2000);
		
//		Wait for element to be visible after selecting gender
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
//		Wait for grid to load as per filter selected
		Thread.sleep(2000);
	}

	public void printItemsCount() {

		String lblXpathItemsFound = "//div[@id='products']//div[@class='length']";
		String itemsFound = driver.findElement(By.xpath(lblXpathItemsFound)).getText();
		System.out.println(itemsFound);
	}

	public void printBrandOfEachProductDisplayed() {
		String lblXpathBrand = "//div[@id='products']//div[@class='brand']";
		
		List<WebElement> findElements = driver.findElements(By.xpath(lblXpathBrand));
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
		}
		
	}

	public void printNameOfBags() {
		String lblXpathProductName = "//div[@id='products']//div[@class='nameCls']";
		
		List<WebElement> findElements = driver.findElements(By.xpath(lblXpathProductName));
		
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
		}
	}

}
