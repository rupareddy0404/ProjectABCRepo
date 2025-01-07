package Executions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import AllPages.LoginPage;

public class TC01_Login_Signin extends LoginPage
{
	public	static String ExcelEmailid="";
	public static 	String ExcelPassword="";
	public static void main(String[] args) throws IOException 
	{
		
		String path = "C:\\Users\\rupaa\\OneDrive\\Documents\\TC-Whatsapp-Status.xlsx";
		
		//Read from excel sheet
		FileInputStream fs = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("testing");
		int rows = sheet.getLastRowNum();
		for (int i = 1; i <= rows; i++) 
		{
			XSSFRow row = sheet.getRow(i);		
			ExcelEmailid=row.getCell(0).getStringCellValue();
			ExcelPassword=row.getCell(1).getStringCellValue();
			
			Application_Launch();
			
			Enter_Email(ExcelEmailid);
			Enter_Password(ExcelPassword);
			Click_Submit();
			
			int cellCount = sheet.getRow(i).getLastCellNum();
		    XSSFCell cell = row.createCell(cellCount);
		    
		   if(driver.getCurrentUrl().equals("https://demo.guru99.com/test/success.html"))
			{
				System.out.println("passed");
				cell.setCellValue("Passed");
			}
			else
			{
				System.out.println("failed");
				cell.setCellValue("failed");
			}
				
		fs.close();
		FileOutputStream fout = new FileOutputStream(path);
		workbook.write(fout);
		fout.close();
		Application_Close();
		}
	
		
		//Enter_Email("testing@gmail.com");
		//Enter_Password("Pw123");
		//Click_Submit();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Application_Close();

	}
}


