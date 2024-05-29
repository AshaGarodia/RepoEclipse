package JavaSessions;
import java.io.File;

import java.io.IOException;

import java.util.Iterator;

import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver.*;
//TargetLocator;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.*;

public class RelLocator {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
ChromeDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Switching Window
		
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);

				Set<String> handles=driver.getWindowHandles();

				Iterator<String> it=handles.iterator();

				String parentWindowId = it.next();

				String childWindow =it.next();

				driver.switchTo().window(childWindow);

				newWindow.get("https://rahulshettyacademy.com/");

				String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

				.get(1).getText();

				driver.switchTo().window(parentWindowId);

				WebElement name=driver.findElement(By.cssSelector("[name='name']"));

				name.sendKeys(courseName);

				//Screenshot of only a desired web element

				File file=name.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(file, new File("logo.png"));

			   //Get Height & Width

				System.out.println(name.getRect().getDimension().getHeight());

				System.out.println(name.getRect().getDimension().getWidth());

				}


		

		}

