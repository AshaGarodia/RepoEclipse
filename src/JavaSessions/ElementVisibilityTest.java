package JavaSessions;
//import java.io.File;
//import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibilityTest {

					public static void main(String[] args) throws InterruptedException {

					System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
					WebDriver driver = new FirefoxDriver();
				
				 driver.manage().window().maximize();

				 driver.manage().deleteAllCookies(); 
				  
				 //driver.get("https://www.facebook.com/signupD%26target%3D%26targetid%3Dkwd-310653717735%26loc_physical_ms%3D9062203%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gad_source=1&gclid=Cj0KCQiA5rGuBhCnARIsAN11vgQWQmN_4cVv7_OAM296BCi9RGzqOGtBLzt3MhZe0wncO_TMEzXMAEMaArC7EALw_wcB");

				 driver.get("https://www.facebook.com/signup");
				 
				 Thread.sleep(2000);
				 
//isDisplayed() method is for all elements. Checks if any element is visible, if yes then returns true else false.
				 
				 boolean b1 = driver.findElement(By.name("websubmit")).isDisplayed();
				 System.out.println(b1);
				 
//isEnabled() method is for all elements. Checks if any element is enable, if yes then returns true else false.
				 
				 boolean b2 = driver.findElement(By.name("websubmit")).isEnabled();
				 System.out.println(b2);
				 
				 
			WebElement element	= driver.findElement(By.name("birthday_day"));
			element.sendKeys("14");
				 boolean b3 = element.isSelected();
				 System.out.println(b3);
				 
				 driver.close();
				 
				
	}

}
