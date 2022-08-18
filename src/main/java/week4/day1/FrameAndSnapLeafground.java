package week4.day1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Utilities.SeMethods;

public class FrameAndSnapLeafground extends SeMethods {

	public static void main(String[] args) throws IOException {
		
		String url = "http://leafground.com/pages/frame.html";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		takeSnap();
		switchToFrame(0);
		click(locateElement("id", "Click"));
		if (getElementText(locateElement("id", "Click")).equalsIgnoreCase("Hurray! You Clicked Me.")) {
			
			System.out.println("Clicked on button inside first Frame");
			
		} else {
			
			System.out.println("Unable to click on button inside first Frame");

		}
		
		switchToFrameDefault();
		List<WebElement> elements = locateElements("tagname", "iframe");
		System.out.println("The count of frames inside Leafground application are " + elements.size());

	}

}
