
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableErail {

	public static WebDriver driver;

	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		maximizeBrowser();
		
		setImplicitWait();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void launchURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}
	
	public void searchTrains() throws InterruptedException {
		String txtIDStationFrom = "txtStationFrom";
		String txtIDStationTo = "txtStationTo";
		String chkIDSortOnDate = "chkSelectDateOnly";
		
		String stationFrom = "MAS";
		String stationTo = "MDU";
		
//		Enter From station
		driver.findElement(By.id(txtIDStationFrom)).clear();
		driver.findElement(By.id(txtIDStationFrom)).sendKeys(stationFrom);
		Thread.sleep(1000);
		driver.findElement(By.id(txtIDStationFrom)).sendKeys(Keys.ENTER);
		
//		Enter To station
		driver.findElement(By.id(txtIDStationTo)).clear();
		driver.findElement(By.id(txtIDStationTo)).sendKeys(stationTo);
		Thread.sleep(1000);
		driver.findElement(By.id(txtIDStationTo)).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id(chkIDSortOnDate)).click();
		Thread.sleep(2000);
		
//		driver.findElement(By.id(chkIDSortOnDate)).sendKeys(Keys.TAB);
	}
	
	public void trainDuplicateCheck() {

		String trClassAllRows = "//table[@class='DataTable TrainList TrainListHeader']//tr";
		
		List<WebElement> eleTableRows = driver.findElements(By.xpath(trClassAllRows));
		int rowCount = eleTableRows.size();
		
		System.out.println("No of Trains available " + rowCount);
		List <String> listTrainNames = new ArrayList<String>();
		Set<String> setTrainNames = new LinkedHashSet<String>();
		for (int i = 1; i <= rowCount; i++) {
			WebElement eleTrainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]"));
			String trainName = eleTrainName.getText();
			listTrainNames.add(trainName);
//			System.out.println(trainName);
//			setTrainNames.add(trainName);
		}

		setTrainNames.addAll(listTrainNames);
		
		if (listTrainNames.size()==setTrainNames.size()) {
			System.out.println("There are no duplicates in the train names and the train count is " + listTrainNames.size());
		}
		else {
			int duplicateCount = listTrainNames.size()-setTrainNames.size();
			System.out.println("There are " + duplicateCount + " duplicates in the train names from the train count " + listTrainNames.size());
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		String url = "http://erail.in";
//		1. Launch https://erail.in
//		2. Enter From as MAS
//		3. Enter To as MDU
//		4. Uncheck sort on Date
//		5. Ensure whether there are duplicate train names

		WebTableErail erail = new WebTableErail();
		erail.initializeDriver();
		erail.launchURL(url);
		erail.searchTrains();
		erail.trainDuplicateCheck();
	}

}
