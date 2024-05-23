package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();


driver.get("https://www.ebay.com/");

Actions a = new Actions(driver);

WebElement moveTo = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));

a.moveToElement(moveTo).click().keyDown(Keys.SHIFT).sendKeys(" hello world").doubleClick().build().perform();

Thread.sleep(2000);

WebElement move = driver.findElement(By.xpath("//a[@class='gh-eb-li-a gh-rvi-menu']"));

a.moveToElement(move).contextClick().build().perform();

Thread.sleep(2000);

driver.close();	
	}
	
	

}
