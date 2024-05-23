package JavaSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;


public class moveToWindow {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();


driver.get("https://rahulshettyacademy.com/loginpagePractise/");

driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

Set<String> windows = driver.getWindowHandles();

Iterator<String> it = windows.iterator();

String parentId= it.next();
String childId = it.next();

driver.switchTo().window(childId);

String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];

driver.switchTo().window(parentId);

driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);




	}

}
