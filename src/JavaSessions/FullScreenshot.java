package JavaSessions;
//import org.apache.poi.xssf.usermodel.*;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver.Timeouts;
import java.io.ByteArrayInputStream;
//import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.awt.Graphics;
import javax.imageio.ImageIO;

public class FullScreenshot {

	public static void main(String[] args) throws InterruptedException {
		
		
		        // Set Chrome driver path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
		
		        // Create a WebDriver instance
		        WebDriver driver = new ChromeDriver();

		        // Navigate to the desired webpage
		        driver.get("https://franklinsouthampton.tekark.com/");

		        // Maximize the browser window to ensure full-page screenshot
		        driver.manage().window().maximize();

		        // Take full-page screenshot
		        try {
		            BufferedImage fullImg = takeFullScreenshot(driver);
		            ImageIO.write(fullImg, "png", new File(".\\Images\\fullPageScreenshot.png"));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        // Close the WebDriver instance
		        driver.close();
		    }

		    // Method to take full-page screenshot
		    public static BufferedImage takeFullScreenshot(WebDriver driver) throws InterruptedException {
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        // Get the total height of the page
		        long totalHeight = (long) js.executeScript("return document.body.scrollHeight");

		        // Take screenshot of the visible portion of the page
		        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		        BufferedImage fullImg = null;

		        try {
		            fullImg = ImageIO.read(new ByteArrayInputStream(screenshotBytes));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        // Scroll and capture screenshots until the end of the page
		        long initialScroll = 0;
		        while (initialScroll < totalHeight) {
		            js.executeScript("window.scrollTo(0, " + initialScroll + ");");
		            Thread.sleep(2000);
		            try {
		                Thread.sleep(2000); // Adjust sleep time if needed
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		            initialScroll += 50; // Adjust scroll height if needed

		            // Take screenshot of the current portion of the page
		            byte[] screenshotPartBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		            BufferedImage screenshotPart = null;
		            try {
		                screenshotPart = ImageIO.read(new ByteArrayInputStream(screenshotPartBytes));
		            } catch (IOException e) {
		                e.printStackTrace();
		            }

		            // Append the screenshot of the current portion to the full page screenshot
		            Graphics g = fullImg.createGraphics();
		            g.drawImage(screenshotPart, 0, (int) initialScroll, null);
		            g.dispose();
		        }

		        return fullImg;
		        
    }
		}
