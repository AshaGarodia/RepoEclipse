package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdowns {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		//how to handle dropdown
		
		Select select = new Select(driver.findElement(By.id("dropdown")));
		select.selectByVisibleText("Option 2");
		
	}

}
