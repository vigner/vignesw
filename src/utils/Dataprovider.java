package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataprovider {
	
	public static Object[][] getExceldata(String dataSheetName) throws InvalidFormatException, IOException
	  {
		  String[][] data=null;
		  File filepath = new File("./data/"+dataSheetName+".xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(filepath);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);
			
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];
			for (int i=1; i<rowCount+1; i++)
			{
				XSSFRow rows = sheet.getRow(i);
				 columnCount = rows.getLastCellNum();
				
				for(int j=0; j<columnCount; j++)
				{
					data[i-1][j]=rows.getCell(j).getStringCellValue();
				}
			}

		return data;
		  
	  }

}
