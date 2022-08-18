package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.SeMethods;

public class ActionSelectable extends SeMethods {

	public static void main(String[] args) {
		String url = "http://www.leafground.com/pages/selectable.html";
		
		chromeSetup();
		initializeDriver();
		launchURL(url);
		
		String ddSelectableItem1 = "//ol[@id='selectable']/li[text()='Item 1']";
		String ddSelectableItem2 = "//ol[@id='selectable']/li[text()='Item 2']";
		
		WebElement eleSelectItem1 = locateElement("xpath", ddSelectableItem1);
		WebElement eleSelectItem2 = locateElement("xpath", ddSelectableItem2);
		
		
		Actions builder = new Actions(driver);
		builder
			.clickAndHold(eleSelectItem1)
			.clickAndHold(eleSelectItem2)
			.release()
			.perform();
	}

}
