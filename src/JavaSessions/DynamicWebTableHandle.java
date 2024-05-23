package JavaSessions;
//import java.io.File;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
	
	 driver.manage().deleteAllCookies(); 
	 
	 driver.navigate().refresh(); 
	 
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	
	 driver.get("https://www.freecrm.com/");
	 
		
	driver.findElement(By.xpath("//a[contains(@class, 'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left')]")).click(); 
	
	Thread.sleep(3000);
	
	driver.findElement(By.name("email")).sendKeys("agarodia.techark@gmail.com");

	driver.findElement(By.name("password")).sendKeys("Balaji@12071988");
	
	driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
		
	// Thread.sleep(2000);
		
//	driver.switchTo().frame("mainpanel");
	Thread.sleep(2000);
	
//	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	//	Thread.sleep(2000);
		
		
	// driver.findElement(By.linkText("Contacts")).click();
	 
	 driver.quit();
	 
	}

}


