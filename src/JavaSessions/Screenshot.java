
package JavaSessions;
import java.io.File;
import java.io.IOException;
//import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class Screenshot {

public static void main(String[] args) throws IOException {

	// Set the path to ChromeDriver executable
    System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
 // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

        // Navigate to the desired webpage
        driver.get("https://franklinsouthampton.tekark.com/");
     //Take screenshot and store as a file format
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     
     //Now copy the file to the desired location using Copyfile method
    FileUtils.copyFile(src, new File(".\\Images\\fullPageScreenshot.png"), true);
    
    driver.close();
 }

}