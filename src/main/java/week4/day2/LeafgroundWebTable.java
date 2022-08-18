package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.SeMethods;

public class LeafgroundWebTable extends SeMethods {

	public static final String SELENIUM_LEARNING_DETAILS_WEBTABLE_XPATH = "//div[@id='contentblock']//table//tr";
	
	public static int webTableColumnCount(String webTableRowsXPath) {
		
		String webTableHeaderXPath = webTableRowsXPath + "/th";
		List<WebElement> tableHeaders = locateElements("xpath", webTableHeaderXPath);
		
		return tableHeaders.size();
	}

	public static int webTableRowCount(String webTableRowsXPath) {
		
		List<WebElement> webTableRows = locateElements("xpath", webTableRowsXPath);
		
		return webTableRows.size();
	}

	public static String webTableFindValueByOffsetColumnValue(String webTableRowsXPath, String textToSearch, int columnToSearch, int columnToFetch) {
		String dataToFetch = "";
		
		List<WebElement> webTableRows = locateElements("xpath", webTableRowsXPath);
		
		for (int i = 1; i < webTableRows.size(); i++) {
			String cellsToSearchXPath = webTableRowsXPath + "[" + i + "]/td";
			String cellToSearchXPath = webTableRowsXPath + "[" + i + "]/td[" + columnToSearch + "]";
			
			if(isElementPresent(By.xpath(cellsToSearchXPath))) {
//				System.out.println("I am in ");
				WebElement eleDataToCompare = locateElement("xpath", cellToSearchXPath);

				if (eleDataToCompare.getText().equals(textToSearch)) {

					String cellToFetchXPath = webTableRowsXPath + "[" + i + "]/td[" + columnToFetch + "]";
					WebElement eleDataToFetch = locateElement("xpath", cellToFetchXPath);
					dataToFetch = eleDataToFetch.getText();
					
					break;
				}
			}
		}
		
		return dataToFetch;
	}
	
	public static void main(String[] args) {

		String url = "http://www.leafground.com/pages/table.html";
		chromeSetup();
		initializeDriver();
		launchURL(url);
		System.out.println("No of columns on the WebTable are : " + webTableColumnCount(SELENIUM_LEARNING_DETAILS_WEBTABLE_XPATH));
		System.out.println("No of rows on the WebTable are : " + webTableRowCount(SELENIUM_LEARNING_DETAILS_WEBTABLE_XPATH));
		
//		String textToSearch = "Learn to interact with Elements";
		String textToSearch = "Learn Locators";
		String offsetValue = webTableFindValueByOffsetColumnValue(SELENIUM_LEARNING_DETAILS_WEBTABLE_XPATH, textToSearch, 1, 2);
		System.out.println("Offset value of " + textToSearch + " is " + offsetValue);
	}

}
