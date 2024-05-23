package JavaSessions;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class WritingIntoExcelDemo1 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Info");
		
		Object EmpData [][] = { {"EmpID","EmpName","EmpJob"},
				{50, "Asha" , "QA Lead"},
			    {100, "Keyur", "Support QA Lead"},
			    {151, "Paresh", "Assisstant QA Lead"}
				};
		
		//Calculating number of rows and columns
		
		int rows = EmpData.length;
		int cols = EmpData[0].length;
		
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r=0;r<rows;r++) {
			XSSFRow row = sheet.createRow(r);
			
			for(int c=0;c<cols;c++) {
				XSSFCell cell = row.createCell(c); 
				Object value = EmpData[r][c];
				
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

