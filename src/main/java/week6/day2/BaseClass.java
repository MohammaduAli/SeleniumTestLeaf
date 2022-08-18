package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static ChromeDriver driver;
	public static String excelFileName;
	
	@Parameters({"url","username","password"})
	@BeforeTest
	public void preCondition(String url, String userName, String password) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
//		Assignment 1:Create Lead
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		String txtIdUserName = "username";
		String txtIdPassword = "password";
		String btnClassNameLogin = "decorativeSubmit";
		String lnkLinkTextCRMSFA = "CRM/SFA";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id(txtIdUserName)).sendKeys(userName);
		driver.findElement(By.id(txtIdPassword)).sendKeys(password);
		
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className(btnClassNameLogin)).click();
		
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText(lnkLinkTextCRMSFA)).click();
		
	}
	
	@AfterTest
	public void postCondition() {
		closeAllBrowser();
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}

	public static String[][] readExcel(String fileName) throws IOException {
		String[][] leadData;
		
		String excelPath = "./data/" + fileName + ".xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook(excelPath);
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum();
		int colCount = ws.getRow(0).getLastCellNum();
		leadData = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				leadData[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		wb.close();
		
		return leadData;
	}
}
