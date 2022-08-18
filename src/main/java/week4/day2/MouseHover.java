
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static WebDriver driver;

	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions());
		
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

	public void closeAllBrowsers() {
		driver.quit();
	}
	
	public ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}

	public void printTitle(String txtBeforeTitle) {

		System.out.println(txtBeforeTitle + driver.getTitle());
		
	}

	/**
	 * @throws InterruptedException
	 */
	public void mouseHoverAndQuickView() throws InterruptedException {
		String lnkXpathMensFashion = "//span[contains(text(),concat('Men', \"'\",'s Fashion'))]";		
		String lnkLinkTextShirts = "Shirts";
		String divXpathFirstWidget = "(//div[@class='clearfix row-disc'])[1]";
		String divXpathFirstWidgetQuickView = "(//div[@class='clearfix row-disc'])[1]/div[contains(text(), 'Quick View')]";
		
//		1. Load https://www.snapdeal.com/
//		2. Mouse hover on Men's Fashion and Click Shirts
//		String lnkXpathMensFashion = "//a[contains(@class,'menuLinks leftCategoriesProduct')]/span[contains(text(),'Men')]";
		
		WebElement eleMensFashion = driver.findElement(By.xpath(lnkXpathMensFashion));
		WebElement eleShirts = driver.findElement(By.linkText(lnkLinkTextShirts));
		
		Actions builder = new Actions(driver);
		builder
			.moveToElement(eleMensFashion)
			.click(eleShirts)
			.perform();

//		3. Mouse hover on the first product and Click on Quick View
		WebElement eleFirstWidget = driver.findElement(By.xpath(divXpathFirstWidget));
		WebElement eleFirstQuickView = driver.findElement(By.xpath(divXpathFirstWidgetQuickView));
		
		if(eleFirstWidget.isDisplayed()) {
			System.out.println("First widget is visible");
		}else {
			System.out.println("First widget is not visible");
		}			
		
		builder
		.moveToElement(eleFirstWidget)
		.click(eleFirstQuickView)
		.perform();
		
		Thread.sleep(2000);
		
//		4. Close all the browsers
		closeAllBrowsers();
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.snapdeal.com/";
		
		MouseHover mouseHover = new MouseHover();
		mouseHover.initializeDriver();
		mouseHover.launchURL(url);
		mouseHover.mouseHoverAndQuickView();
	}

}
