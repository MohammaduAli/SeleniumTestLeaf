package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Utilities.SeMethods;

public class ActionSortableLeafGround extends SeMethods{

	public static void main(String[] args) {

		String url = "http://www.leafground.com/pages/sortable.html";
		chromeSetup();
		initializeDriver();
		launchURL(url);

		String sortableItem1 = "//ul[@id='sortable']/li[text()='Item 1']";
		String sortableItem2 = "//ul[@id='sortable']/li[text()='Item 4']";
		
		WebElement eleSortableItem1 = locateElement("xpath", sortableItem1);
		WebElement eleSortableItem2 = locateElement("xpath", sortableItem2);

		int height1 = eleSortableItem1.getRect().getHeight();
		System.out.println(height1);
		
		Point location1 = eleSortableItem1.getLocation();
		int x1 = location1.getX();
		int y1 = location1.getY();
		System.out.println(x1 +" "+ y1);
		
		Point location2 = eleSortableItem2.getLocation();
		int x2 = location2.getX();
		int y2 = location2.getY();
		System.out.println(x2 +" "+ y2);
		
//		Top to Bottom Sorting
		int xOffset = x2-x1;
		int yOffset = y2-y1+2;
		
		Actions builder = new Actions (driver);
		builder
			.dragAndDropBy(eleSortableItem1, xOffset, yOffset)
			.perform();
	}

}
