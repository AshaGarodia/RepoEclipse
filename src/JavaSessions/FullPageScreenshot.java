package JavaSessions;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import org.openqa.selenium.WebDriver.Timeouts;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

public class FullPageScreenshot {
	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver


		//System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
	//	WebDriver driver = new FirefoxDriver();
		
driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

//Navigate to the webpage
driver.get("https://franklinsouthampton.tekark.com/");

java.io.File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		

FileUtils.copyToFile(scrFile, new File(".\\Images\\fullPageScreenshot.png"));

//Close the browser
driver.quit();
	}
	

public static void copyFile(java.io.File scrFile, File file) {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
return;
}

}


