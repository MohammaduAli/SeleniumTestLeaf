package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeMethods extends JavaMethods{

	public static ChromeDriver driver;
	public static WebDriverWait wait;
	
	public static void chromeSetup() {

		WebDriverManager.chromedriver().setup();
	}

	public static void initializeDriver() {
		driver = new ChromeDriver(chromeOptions());
		
		maximizeBrowser(driver);
		
		setImplicitWait(driver);
	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void launchURL(String url) {
		driver.get(url);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllBrowsers() {
		driver.quit();
	}
	
	public static void initializeDriver(ChromeDriver driver) {
		driver = new ChromeDriver(chromeOptions());
		
		maximizeBrowser(driver);
		
		setImplicitWait(driver);
	}

	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}

	public static void maximizeBrowser(ChromeDriver driver) {
		driver.manage().window().maximize();
	}

	public static void setImplicitWait(ChromeDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void launchURL(ChromeDriver driver, String url) {
		driver.get(url);
	}

	public static void closeBrowser(ChromeDriver driver) {
		driver.close();
	}

	public static void closeAllBrowsers(ChromeDriver driver) {
		driver.quit();
	}

	public static String getTitle() {

		return driver.getTitle();
		
	}

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
//	Frame
	public static void switchToFrame(int index) {
		
		driver.switchTo().frame(index);
		
	}

	public static void switchToFrame(WebElement ele) {
		
		driver.switchTo().frame(ele);
		
	}
	
	public static void switchToFrame(String frameNameOrId) {
		
		driver.switchTo().frame(frameNameOrId);
		
	}
	
	public static void switchToFrameDefault() {
		driver.switchTo().defaultContent();
	}	

	public static void switchToFrameParent() {
		driver.switchTo().parentFrame();
	}

//	Window
	public static void switchToFirstWindow() {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(0));
	}
	
	public static void switchToSecondWindow() {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(1));
	}
	
//	Alert
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
//	Title with driver
	public static String getTitle(ChromeDriver driver) {

		return driver.getTitle();
		
	}

	public static void printTitle(ChromeDriver driver, String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
//	Frame with driver
	public static void switchToFrame(ChromeDriver driver, String frameNameOrId) {
		
		driver.switchTo().frame(frameNameOrId);
		
	}
	
	public static void switchToFrameDefault(ChromeDriver driver) {
		driver.switchTo().defaultContent();
	}	

	public static void switchToFrameParent(ChromeDriver driver) {
		driver.switchTo().parentFrame();
	}

//	Window with driver
	public void switchToFirstWindow(ChromeDriver driver) {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(0));
	}
	
	public void switchToSecondWindow(ChromeDriver driver) {
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList<String>();
		 listHandles.addAll(windowHandles);
		 driver.switchTo().window(listHandles.get(1));
	}
	
	public void acceptAlert(ChromeDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

//	Snapshot
	public static void takeSnap() throws IOException {
		// take the screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		// Creating physical file
		File destination = new File("./snaps/screenshot.png");
		
		// Copy source to destination
		FileUtils.copyFile(source, destination);
	}
	
//	Element
	public static boolean isElementPresent(ChromeDriver driver, By selector){

		return driver.findElements(selector).size()>0;
		
	}

	public static boolean isElementPresent(By selector){

		return driver.findElements(selector).size()>0;
		
	}

	public static void verifyElementIsVisible(WebElement element, String elementName) {

		if(element.isDisplayed()) {
			System.out.println(elementName + " is visible");
		}else {
			System.out.println(elementName + " is not visible");
		}	
		
	}
	
	public static WebElement locateElement(String locatorType, String value) {
		
		switch(locatorType.toLowerCase()){
			case "id": return driver.findElement(By.id(value));
			case "name": return driver.findElement(By.name(value));
			case "linktext": return driver.findElement(By.linkText(value));
			case "partiallinktext": return driver.findElement(By.partialLinkText(value));
			case "xpath": return driver.findElement(By.xpath(value));
			case "tagname": return driver.findElement(By.tagName(value));
			case "classname": return driver.findElement(By.className(value));	// Does not work if the value contains any special characters
		}
		
		return null;
	}

	public static WebElement locateElementAfterWait(Duration waitForSeconds, String locatorType, String value) {
		try {
			Thread.sleep(waitForSeconds.toMillis());
			
			switch(locatorType.toLowerCase()){
				case "id": return driver.findElement(By.id(value));
				case "name": return driver.findElement(By.name(value));
				case "linktext": return driver.findElement(By.linkText(value));
				case "partiallinktext": return driver.findElement(By.partialLinkText(value));
				case "xpath": return driver.findElement(By.xpath(value));
				case "tagname": return driver.findElement(By.tagName(value));
				case "classname": return driver.findElement(By.className(value));	// Does not work if the value contains any special characters
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> locateElements(String locatorType, String value) {
		
		switch(locatorType.toLowerCase()){
			case "id": return driver.findElements(By.id(value));
			case "name": return driver.findElements(By.name(value));
			case "linktext": return driver.findElements(By.linkText(value));
			case "partiallinktext": return driver.findElements(By.partialLinkText(value));
			case "xpath": return driver.findElements(By.xpath(value));
			case "tagname": return driver.findElements(By.tagName(value));
			case "classname": return driver.findElements(By.className(value));
		}
		
		return null;
	}

	public static List<WebElement> locateElementsAfterWait(Duration waitForSeconds, String locatorType, String value) {
		try {
			Thread.sleep(waitForSeconds.toMillis());
				
			switch(locatorType.toLowerCase()){
				case "id": return driver.findElements(By.id(value));
				case "name": return driver.findElements(By.name(value));
				case "linktext": return driver.findElements(By.linkText(value));
				case "partiallinktext": return driver.findElements(By.partialLinkText(value));
				case "xpath": return driver.findElements(By.xpath(value));
				case "tagname": return driver.findElements(By.tagName(value));
				case "classname": return driver.findElements(By.className(value));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getElementText(WebElement ele) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		return ele.getText();
		
	}

	public static List<String> getElementsText(List<WebElement> elements) {

		List<String> listText = new ArrayList<String>();
		for (WebElement element : elements) {
			listText.add(element.getText());
			System.out.println(element.getText());
		}
		
		return listText;
		
	}

	public static List<String> getElementsAttributeValue(List<WebElement> elements, String attributeName) {

		List<String> listText = new ArrayList<String>();
		for (WebElement element : elements) {
			listText.add(element.getAttribute(attributeName));
//			System.out.println(element.getAttribute(attributeName));
		}
		
		return listText;
		
	}

	public static List<Integer> getElementsAttributeIntegerValue(List<WebElement> elements, String attributeName) {

		List<Integer> listText = new ArrayList<Integer>();
		for (WebElement element : elements) {
			listText.add(Integer.valueOf(element.getAttribute(attributeName).trim()));
//			System.out.println(element.getAttribute(attributeName));
		}
		
		return listText;
		
	}

	public static String getElementTextAfterWait(WebElement ele) {

		try {
			Thread.sleep(1000);

			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			return ele.getText();
		}catch(Exception e) {
			
		}
		return null;
	}

	public static void verifyExactText(WebElement ele, String exactTextExpected) {
		String actText = getElementText(ele);
		if(actText.equals(exactTextExpected)) {
			System.out.println("The expected text " + exactTextExpected + " matches exactly with the actual text " + actText);
		}
	}

	public static void verifyPartialText(WebElement ele, String expectedText) {
		String actText = getElementText(ele);
		if(expectedText.contains(actText)) {
			
			System.out.println("The expected text " + expectedText + " contain the actual text " + actText);
			
		}else {

			System.out.println("The expected text " + expectedText + " does not contain the actual text " + actText);
			
		}
	}
	
//	Text Input Field
	public static void clear(WebElement ele) {
	
		ele.clear();
		
	}

	public static void clearAndType(WebElement ele, String data) {
	
		ele.clear();
		ele.sendKeys(data);
		
	}

	public static void append(WebElement ele, String data) {
	
		ele.sendKeys(data);
		
	}

	public static String getTypedText(WebElement ele) {
		
		return ele.getAttribute("value");
		
	}
	
//	Click
	public static void click(WebElement ele) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}

	public static void click(WebElement ele, int seconds) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}
	
	public static void click(String locatorType, String value) {

		try {
			
			WebElement ele = locateElement(locatorType, value);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch(StaleElementReferenceException e) {
			
			WebElement ele = locateElement(locatorType, value);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		}
		
	}

	public static void clickAfterWait(Duration durSeconds, String locatorType, String value) {

		try {
			Thread.sleep(durSeconds.toMillis());
			
			WebElement ele = locateElement(locatorType, value);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch(StaleElementReferenceException e) {
			
			WebElement ele = locateElement(locatorType, value);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
//	Select dropdown
	public static void selectByVisibleText(WebElement ele, String visibleText) {
		Select dd = new Select(ele);
		dd.selectByVisibleText(visibleText);
	}

	public static void selectByValue(WebElement ele, String value) {
		Select dd = new Select(ele);
		dd.selectByValue(value);
	}

	public static void selectByIndex(WebElement ele, int index) {
		Select dd = new Select(ele);
		dd.selectByIndex(index);
	}

	public static void deselectByVisibleText(WebElement ele, String visibleText) {
		Select dd = new Select(ele);
		dd.deselectByVisibleText(visibleText);
	}

	public static void deselectByValue(WebElement ele, String value) {
		Select dd = new Select(ele);
		dd.deselectByValue(value);
	}

	public static void deselectByIndex(WebElement ele, int index) {
		Select dd = new Select(ele);
		dd.deselectByIndex(index);
	}

//	Actions
	public static void actionMouseOverAndClick(WebElement eleToHover, WebElement eleToClick) {
		Actions builder = new Actions(driver);
		builder
			.moveToElement(eleToHover)
			.click(eleToClick)
			.perform();
		
	}

	public static void actionLongPress(WebElement eleToLongPress) {
		Actions builder = new Actions(driver);
		builder
		.clickAndHold(eleToLongPress)
		.pause(Duration.ofSeconds(4))
		.release()		
		.perform();
	}
	
	public static void actionResizeElement(WebElement eleToResize, int xOffset, int yOffset) {
		new Actions(driver)
			.clickAndHold(eleToResize)
			//.moveByOffset(-50, -50) To shrink
			.moveByOffset(xOffset, yOffset)	//To expand
			.release()
			.perform();
	}

	public static void actionDragAndDropByOffset(WebElement eleSource, int xOffset, int yOffset) {
		new Actions(driver)
			.dragAndDropBy(eleSource, xOffset, yOffset)
			.perform();
	}

	public static void actionDragAndDrop(WebElement source, WebElement destination) {
		new Actions(driver)
			.dragAndDrop(source, destination)
			.perform();
	}
	
	public static void actionSortTopToBottom(WebElement source, WebElement destination) {

		int height1 = source.getRect().getHeight();
		System.out.println(height1);
		
		Point location1 = source.getLocation();
		int x1 = location1.getX();
		int y1 = location1.getY();
		System.out.println(x1 +" "+ y1);
		
		Point location2 = destination.getLocation();
		int x2 = location2.getX();
		int y2 = location2.getY();
		System.out.println(x2 +" "+ y2);
		
//		Top to Bottom Sorting
		int xOffset = x2-x1;
		int yOffset = y2-y1+2;
		
		Actions builder = new Actions (driver);
		builder
			.dragAndDropBy(source, xOffset, yOffset)
			.perform();
	}
}
