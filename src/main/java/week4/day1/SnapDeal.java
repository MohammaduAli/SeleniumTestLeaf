package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ISelect;

import Utilities.SeMethods;

public class SnapDeal extends SeMethods{

	public static void main(String[] args) {
		
		String url = "https://www.snapdeal.com/";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		
		WebElement eleToHover = locateElement("xpath", "//a[@class='menuLinks leftCategoriesProduct ']/span[@class='catText'][text()=concat('Men', \"'\",'s Fashion')]");
		WebElement eleToClick = locateElement("xpath", "(//span[@class='linkTest'][text()='Sports Shoes'])[1]");
		actionMouseOverAndClick(eleToHover, eleToClick);
		
		String countSportShoes = getElementText(locateElement("xpath", "//div[text()='Sports Shoes for Men']/following-sibling::div"));
		System.out.println("Count of Sport Shoes is " + countSportShoes);
		click(locateElement("xpath", "//div[text()='Training Shoes']"));
		click(locateElementAfterWait(Duration.ofSeconds(2), "xpath", "//div[@class='sorting-sec animBounce']"));
		click(locateElement("xpath", "//div[@class='sorting-sec animBounce']//li[contains(., 'Price Low To High')]"));
		
		List<WebElement> eleShoePrices = locateElementsAfterWait(Duration.ofSeconds(5), "xpath", "//span[@class='lfloat product-price']");
		List<Integer> listShoePrices = getElementsAttributeIntegerValue(eleShoePrices, "display-price");
		List<Integer> listShoePricesBeforeSort = new ArrayList<Integer>(listShoePrices);
		
		Collections.sort(listShoePrices);
		boolean status = listCompare(listShoePricesBeforeSort, listShoePrices);
		if (status) {
			
			System.out.println("Items are listed from Price Low to High");
			
		} else {

			System.out.println("Items are not listed from Price Low to High");
			
		}
		
		clearAndType(locateElement("name", "fromVal"), "900");
		clearAndType(locateElement("name", "toVal"), "1200");
		click(locateElement("xpath", "//div[contains(@class, 'price-go-arrow')]"));
//		click(locateElementAfterWait(Duration.ofSeconds(5), "xpath", "//div[@data-name='Color_s']//input[@value='Navy']"));
		
		boolean isPriceSelected = isElementPresent(By.xpath("//div[@class='filters-top-selected']//a[@data-key='Price|Price']"));
		boolean isColorSelected = isElementPresent(By.xpath("//div[@class='filters-top-selected']//a[@data-key='Color_s|Color']"));
		if (isPriceSelected) {
			System.out.println("Price filter is selected");
		} else {
			System.out.println("Price filter is not selected");
		}
		if (isColorSelected) {
			System.out.println("Color filter is selected");
		} else {
			System.out.println("Color filter is not selected");
		}
		
		WebElement eleToHover2 = locateElement("xpath", "(//div[@class='product-tuple-image '])[1]");
		WebElement eleToClick2 = locateElement("xpath", "(//div[@class='product-tuple-image '])[1]//div[@supc][contains(., 'Quick View')]");
		actionMouseOverAndClick(eleToHover2, eleToClick2);
		
		String priceOfSelected = getElementText(locateElement("xpath", "//div[contains(@class,'product-price pdp')]/span[1]"));
		String discountOfSelected = getElementText(locateElement("xpath", "//div[contains(@class,'product-price pdp')]/span[2]"));
		System.out.println("Price of the selected item is " + priceOfSelected);
		System.out.println("Discount of the selected item is " + discountOfSelected);
	}
}
