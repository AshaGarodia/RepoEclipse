package JavaSessions;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver.Timeouts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GooglePageSpeedScoresCronJobTest {

public static void main(String[] args) throws InterruptedException {
// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

       
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream(".\\DataFiles\\FranklinSite_LiveScores.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each row in the Excel sheet
            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                         	
                 	// Get the URL from the Excel sheet
                    XSSFCell urlCell = row.getCell(0);
                    String url = urlCell.getStringCellValue();
                   
                    System.out.println("The URL is " +url);

                    // Navigate to Google Page Speed Insights website
                                
                    driver.get("https://developers.google.com/speed/pagespeed/insights/");
                    // Enter the URL
                    WebElement urlInput = driver.findElement(By.xpath("//input[@placeholder='Enter a web page URL']"));
                    urlInput.sendKeys(url);
                   
                    Thread.sleep(2000);
                    // Click on the Analyze button
                    WebElement analyzeButton = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 c659ib']"));
                    analyzeButton.click();
                                              
                    Thread.sleep(5000);

                   
   driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
   
   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
   
 //Clicking the mobile button
  //driver.findElement(By.xpath("//button[@id='mobile_tab']")).click();
   
                    // Extract the Mobile - Page Speed scores
   
                    WebElement performance = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[1]"));
                   
                    WebElement accessibility = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[2]"));
                 
                    WebElement bestpractices = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[3]"));
                    
                    WebElement seo = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[4]"));
                 
                    if(performance == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                                     
                    if(accessibility == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                    
                    if(bestpractices == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                    if(seo == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                    
            
                    //Printing the values on the console   
                    
                    String mobileScorePerformance = performance.getText();
                    System.out.println("The mobile performance score is  " +mobileScorePerformance);
                   
                   
                    String mobileScoreAccessibility = accessibility.getText();
                    System.out.println("The mobile accessibility score is  " +mobileScoreAccessibility);
                    
                    String mobileScoreBestPractices = bestpractices.getText();
                    System.out.println("The mobile best practices score is  " +mobileScoreBestPractices);
                    
                    String mobileScoreSeo = seo.getText();
                    System.out.println("The mobile seo score is  " +mobileScoreSeo);
                    
                    //Clicking the desktop button
                    
                  driver.findElement(By.xpath("//button[@id='desktop_tab']")).click();
                 
                 // Write the scores back to the Excel sheet
                    
                    XSSFCell scoreCellMobileScorePerformance = row.createCell(1);
                    scoreCellMobileScorePerformance.setCellValue(mobileScorePerformance);
                   
                   
                    XSSFCell scoreCellMobileScoreAccessibility = row.createCell(2);
                    scoreCellMobileScoreAccessibility.setCellValue(mobileScoreAccessibility);
                   
                    XSSFCell scoreCellMobileScoreBestPractices = row.createCell(3);
                    scoreCellMobileScoreBestPractices.setCellValue(mobileScoreBestPractices);
                    
                    XSSFCell scoreCellMobileScoreSeo = row.createCell(4);
                    scoreCellMobileScoreSeo.setCellValue(mobileScoreSeo);
                    
                
                    // Extract the Desktop - Page Speed scores
                    
                  WebElement dPerformance = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[5]"));
                    
                  
                  WebElement dAccessibility= driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[6]"));
                   
                      
                  WebElement dBestPractices = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[7]"));
                  
                  
                  WebElement dSeo = driver.findElement(By.xpath("(//div[@class='lh-scores-wrapper']//div[@class='lh-scores-header']//div[@class='lh-gauge__percentage'])[8]"));
                  
                  //Printing the values on the console  
                  
                  if(dPerformance == null) {
                    System.out.println("Error");
                  	continue;
                  }
                  
                  if(dAccessibility == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                    
                  if(dBestPractices == null) {
                  	System.out.println("Error");
                  	continue;
                  }
                  
                  if(dSeo == null) {
                    	System.out.println("Error");
                    	continue;
                    }
                    
                   String desktopScorePerformance = dPerformance.getText();
                   System.out.println("The desktop performance score is  " +desktopScorePerformance);
                   
                   String desktopScoreAccessibility = dAccessibility.getText();
                   System.out.println("The desktop accessibility score is  " +desktopScoreAccessibility);
                   
                   String desktopScoreBestPractices = dBestPractices.getText();
                   System.out.println("The desktop best practices score is  " +desktopScoreBestPractices);
                   
                   String desktopScoreSeo = dSeo.getText();
                   System.out.println("The desktop seo score is  " +desktopScoreSeo);

                    // Write the scores back to the Excel sheet
                    
                 XSSFCell scoreCellDesktopScorePerformance = row.createCell(5);
                 scoreCellDesktopScorePerformance.setCellValue(desktopScorePerformance);
                 
                 XSSFCell scoreCellDesktopScoreAccessibility = row.createCell(6);
                 scoreCellDesktopScoreAccessibility.setCellValue(desktopScoreAccessibility);
                 
                 XSSFCell scoreCellDesktopScoreBestPractices = row.createCell(7);
                 scoreCellDesktopScoreBestPractices.setCellValue(desktopScoreBestPractices);
                 
                 XSSFCell scoreCellDesktopScoreSeo = row.createCell(8);
                 scoreCellDesktopScoreSeo.setCellValue(desktopScoreSeo);

                    // Wait to avoid being blocked by Google
                    Thread.sleep(2000);
                }
            }

            // Write the updated workbook back to the Excel file
            
            FileOutputStream outputStream = new FileOutputStream(".\\DataFiles\\FranklinSite_LiveScores.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Page Speed scores have been added to the Excel sheet.");

        } 
        catch (IOException | InterruptedException e)
        {
        e.printStackTrace();
            
        } 
        finally {
            // Close the WebDriver
            driver.close();
        }
    }



}