package JavaSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class CustomXpath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");	
		
	//	driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		
	//	driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Java");

	//	driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
		
	//	driver.findElement(By.xpath("//input[starts-with(@id,'test')]")).sendKeys("Test");
		
		//How to create custom xPath for links
		
		driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).click();
		
		
	}

}
