package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	static void readExcelBasic() throws IOException {
		
		String excelPath = "./data/FirstData.xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook(excelPath);
		
		XSSFSheet ws = wb.getSheet("LeadData");
		
		XSSFRow row = ws.getRow(1);
		
		XSSFCell cell = row.getCell(0);
		
		String cellData = cell.getStringCellValue();
		
		System.out.println(cellData);
		
		wb.close();
	}

	static void readExcelDynamic() throws IOException {
		
		String excelPath = "./data/FirstData.xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook(excelPath);
		
		XSSFSheet ws = wb.getSheet("LeadData");
		
		int rowCount = ws.getLastRowNum();
		int colCount = ws.getRow(0).getLastCellNum();
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = ws.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println(cellData);
				
			}
		}
		
		wb.close();
	}

	public static String[][] readExcelLeadData(String fileName) throws IOException {
		String[][] leadData;
		
		String excelPath = "./data/" + fileName + ".xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook(excelPath);
		
		XSSFSheet ws = wb.getSheet("LeadData");
		
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

//	public static void main(String[] args) throws IOException {
//
//		readExcelLeadData("CreateLead");
//		
//	}

}
