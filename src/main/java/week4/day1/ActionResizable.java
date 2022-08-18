package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.SeMethods;

public class ActionResizable extends SeMethods{

	public static void main(String[] args) {

		String url = "https://jqueryui.com/resizable/";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		WebElement eleFrame = locateElement("classname", "demo-frame");
		switchToFrame(eleFrame);
		
		WebElement eleToResize = locateElement("xpath", "//div[@id='resizable']/div[contains(@class, 'icon')]");		
		Actions actions = new Actions(driver);
		actions
			.clickAndHold(eleToResize)
			//.moveByOffset(-50, -50) To shrink
			.moveByOffset(50, 50)	//To expand
			.release()
			.perform();
		
		actionResizeElement(eleToResize, -10, -60);
	}

}
