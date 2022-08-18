package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.SeMethods;

public class ActionDrop extends SeMethods{

	public static void main(String[] args) {

		String url = "http://www.leafground.com/pages/drop.html";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		
		WebElement eleSource = locateElement("id", "draggable");
		WebElement eleDestination = locateElement("id", "droppable");
		WebElement eleParentDiv = locateElement("id", "mydiv");
		
		Actions builder = new Actions(driver);
		builder
			.dragAndDrop(eleSource, eleDestination)
			.perform();
		
		actionDragAndDrop(eleSource, eleParentDiv);
	}

	public static void actionDragAndDrop(WebElement source, WebElement destination) {
		Actions builder = new Actions(driver);
		builder
			.dragAndDrop(source, destination)
			.perform();
	}
}
