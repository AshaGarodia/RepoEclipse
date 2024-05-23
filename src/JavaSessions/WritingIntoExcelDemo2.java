package JavaSessions;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class WritingIntoExcelDemo2 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Info");
		
		Object EmpData [][] = { {"EmpID","EmpName","EmpJob"},
				{50, "Asha" , "QA Lead"},
			    {100, "Keyur", "Support QA Lead"},
			    {151, "Paresh", "Assisstant QA Lead"}
				};
		

		//Use for each loop instead of for loop
		
		int rowCount = 0;
		
	for(Object emp[]:EmpData)	
	{
		XSSFRow row = sheet.createRow(rowCount++);
		int columnCount = 0;
		for(Object value:emp)
		{
			XSSFCell cell =	row.createCell(columnCount++);
			if(value instanceof String)
				cell.setCellValue((String)value);
		if(value instanceof Integer)
				cell.setCellValue((Integer)value);
		if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		}
		
		
		}
		
		
		String filePath = ".\\DataFiles\\EmployeesInfo.xlsx";
		FileOutputStream outstream = new FileOutputStream(filePath);
		workbook.write(outstream);
		
		outstream.close();
		
		workbook.close();
		System.out.println("Employee information has been written successfully");
		
	}	

}
