package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Base.TestBase;

public class ReadExcel extends TestBase
{
	public static String readExcelFile(int rowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\10711204\\eclipse-workspace\\"
			                                	+ "Automation_UI\\src\\test\\resources\\TestData\\Xpaths.xlsx");
	    Sheet excelSheet = WorkbookFactory.create(file).getSheet("HBI");
	    String value = excelSheet.getRow(rowNum).getCell(CellNum).getStringCellValue();
	    return value;
	}
}
