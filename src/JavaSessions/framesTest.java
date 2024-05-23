package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesTest {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();


driver.get("https://jqueryui.com/droppable/");

System.out.println(driver.findElements(By.tagName("iframe")).size());

driver.switchTo().frame(0);

Actions a = new Actions(driver);

WebElement source = driver.findElement(By.id("draggable"));

WebElement target = driver.findElement(By.id("droppable"));

a.dragAndDrop(source, target).build().perform();

Thread.sleep(2000);

driver.switchTo().defaultContent();

 driver.close();

}

}
