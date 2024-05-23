package JavaSessions;

import java.io.FileInputStream;
import java.io.IOException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

public static void main(String[] args) throws IOException {
String filePath = ".\\DataFiles\\EmployeesData.xlsx";
FileInputStream inputstream = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
XSSFSheet sheet = workbook.getSheet("Sheet1");
//XSSFSheet sheet = workbook.getSheetAt(0);
//Using for loop
int rows = sheet.getLastRowNum();
//int cols = sheet.getRow(1).getLastCellNum();
for(int r = 0; r<rows; r++) 
{
XSSFRow row = sheet.getRow(r);
int cols = row.getLastCellNum();
for (int c = 0; c<cols; c++)
{
XSSFCell cell = row.getCell(c);
switch(cell.getCellType())
{
case STRING : System.out.print(cell.getStringCellValue()); 
break;
case NUMERIC : System.out.print(cell.getNumericCellValue());
break;
case BOOLEAN : System.out.print(cell.getBooleanCellValue());
break;
}
System.out.print("  |  ");
}//one cell's value is obtained
System.out.println();
}

}
}


//for (int r = 0; r <= rows; r++) {
//    XSSFRow row = sheet.getRow(r);
//    if (row != null) {
//        int cols1 = row.getLastCellNum(); // Moved cols calculation inside the loop for each row
//        for (int c = 0; c < cols1; c++) {
//            XSSFCell cell = row.getCell(c);
//            if (cell != null) {
//                switch (cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                }
//            }
//            System.out.print("  |  ");
//        }
//        System.out.println();
//    }
//}
//}
//}
