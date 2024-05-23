package JavaSessions;
//import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PageSpeedTrial {

	public static void main(String[] args) {
	

		        // Set the path to ChromeDriver executable
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");

		        // Initialize ChromeDriver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Load the Excel file
		            FileInputStream fis = new FileInputStream(".\\DataFiles\\urls.xlsx");
		            XSSFWorkbook workbook = new XSSFWorkbook(fis);
		            XSSFSheet sheet = workbook.getSheetAt(0);

		            // Iterate through each row in the Excel sheet
		            for (int i = 0; i < sheet.getLastRowNum(); i++) {
		                XSSFRow row = sheet.getRow(i);
		                if (row != null) {
		                    // Get the URL from the Excel sheet
		                    XSSFCell urlCell = row.getCell(0);
		                    String url = urlCell.getStringCellValue();
		                    System.out.println("The URL is " +url);
		                    
		                    // Navigate to Google PageSpeed Insights for the URL
		                    driver.get("https://developers.google.com/speed/pagespeed/insights/");
		                    
		                    WebElement urlInput = driver.findElement(By.xpath("//input[@placeholder='Enter a web page URL']"));
		                    urlInput.sendKeys(url);
		                    
		                    // Click on the Analyze button
		                    WebElement analyzeButton = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 c659ib']"));
		                    analyzeButton.click();

		                    // Extract the PageSpeed scores for mobile and desktop
		                    WebElement desktopScoreElement = driver.findElement(By.xpath("//div[@class='lh-gauge__percentage']"));
		                    String desktopScore = desktopScoreElement.getText();

		                    WebElement mobileScoreElement = driver.findElement(By.xpath("//div[@class='lh-score__gauge']"));
		                    String mobileScore = mobileScoreElement.getText();

		                    // Write the scores back to the Excel sheet
		                    XSSFCell desktopCell = row.createCell(1);
		                    desktopCell.setCellValue(desktopScore);

		                    XSSFCell mobileCell = row.createCell(2);
		                    mobileCell.setCellValue(mobileScore);
		                }
		            }

		            // Write the updated workbook back to the Excel file
		            FileOutputStream outputStream = new FileOutputStream("urls.xlsx");
		            workbook.write(outputStream);
		            workbook.close();
		            outputStream.close();
		            System.out.println("PageSpeed scores have been added to the Excel sheet.");

		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            // Close the WebDriver
		            driver.close();
		        }
		    }
		}


	


