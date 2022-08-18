package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.SeMethods;

public class Nykaa extends SeMethods {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.nykaa.com/";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		String linkTextBrands = "Brands";	//brands linktext not working
		String xpathBrands = "//div[@id='headerMenu']/div[1]/ul[2]";
		
		String xpathLorealparis = "(//div[contains(@class,'brandsNameboxWrapper')]//a[contains(text(),concat('L', \"'\", 'Oreal Paris'))])[1]";
		Thread.sleep(2000);

//		actionMouseOverAndClick(locateElement("xpath", xpathBrands), locateElement("xpath", xpathLorealparis));
		actionMouseOverAndClick(locateElement("linktext", linkTextBrands), locateElement("xpath", xpathLorealparis));
		
		String brandName = "L'Oreal Paris";
		String title = getElementText(locateElement("id", "title"));
		if (title.contains(brandName)) {
			
			System.out.println("Title contains the text " + brandName);
			
		} else {

			System.out.println("Title does not contain the text " + brandName);
		}
		
		click(locateElement("id", "filter-sort"));
		click(locateElement("xpath", "//input[@id='radio_customer top rated_undefined']/following-sibling::label"));
		click(locateElement("xpath", "//span[@class='title '][text()='Category']"));
		verifyElementIsVisible(locateElement("classname", "sort-name"), "Customer Top Rated");
		clickAfterWait(Duration.ofSeconds(2), "xpath", "//span[@class='filter-name '][text()='Hair']");
		click(locateElement("xpath", "//span[@class='filter-name '][text()='Hair Care']"));
		click("xpath", "//input[contains(@id,'Shampoo')]/following-sibling::label");
		
		click(locateElement("xpath", "//span[@class='title '][text()='Concern']"));
		click("xpath", "//input[contains(@id,'Color Protection')]/following-sibling::label");
		verifyElementIsVisible(locateElement("xpath", "//div[@id='filters-listing']//span[@class='filter-value'][text()='Color Protection']"), "Color Protection");

		click(locateElement("xpath", "//div[contains(@class, 'productWrapper')]//div[text()=concat('L', \"'\", 'Oreal Paris Colour Protect Shampoo')]"));
		switchToSecondWindow();
		selectByVisibleText(locateElement("xpath", "//*[@title='SIZE']"), "175ml");
		
		String mrpXpath = "//div[text()='inclusive of all taxes']/preceding-sibling::div//span[text()='MRP:']/following-sibling::span";
		String elementText = getElementTextAfterWait(locateElement("xpath", mrpXpath));
		System.out.println("MRP of Oreal Paris Colour Protect Shampoo is " + elementText);
		
		click(locateElement("xpath", "(//span[text()='ADD TO BAG'])[1]"));
		click("classname", "cart-count");
		
		switchToFrame(locateElement("xpath", "//iframe[contains(@src,'ptype=customIframeCart')]"));
		String grandTotal = getElementText(locateElementAfterWait(Duration.ofSeconds(5), "xpath", "//span[text()='Grand Total']/following-sibling::div"));
		System.out.println("Grand Total is "+ grandTotal);
		
		click(locateElement("xpath", "//button[contains(@class,'proceed')]"));
		
		click(locateElement("xpath", "//button[text()='CONTINUE AS GUEST']"));
		
		verifyPartialText(locateElement("xpath", "//div[text()='Grand Total']/following-sibling::div/span"), grandTotal);
		
		closeAllBrowsers();
	}

}
