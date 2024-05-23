package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class TestDropDown {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

driver.get("https://demo.automationtesting.in/Register.html");

WebElement element = driver.findElement(By.id("msdd"));

element.click();

WebElement englishOption = driver.findElement(By.xpath("//a[contains(text(),'English')]"));

englishOption.click();

System.out.println("Language selected is English" );

driver.close();

	}

}
