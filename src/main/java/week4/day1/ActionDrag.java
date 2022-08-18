package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.SeMethods;

public class ActionDrag extends SeMethods{

	public static void main(String[] args) {

		String url = "http://www.leafground.com/pages/drag.html";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		WebElement eleSource = locateElement("id", "draggable");
		int xOffset = 100;
		int yOffset = 100;
		
		Actions builder = new Actions(driver);
		builder
			.dragAndDropBy(eleSource, xOffset, yOffset)
			.perform();
		actionDragAndDropByOffset(eleSource, -xOffset, -yOffset);
	}

	public static void actionDragAndDropByOffset(WebElement eleSource, int xOffset, int yOffset) {
		new Actions(driver)
			.dragAndDropBy(eleSource, xOffset, yOffset)
			.perform();
	}
}
