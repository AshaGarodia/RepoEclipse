package JavaSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class FindElementsConcept {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
		
	
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");	
		
		//find total number of links on any webpage
		
		List<WebElement> countoflinks = driver.findElements(By.tagName("a"));
		System.out.println(countoflinks.size());
		
		//find the text of each of the links on any webpage
		
		for(int i=0;i<=countoflinks.size();i++) {
			String linkText = countoflinks.get(i).getText();
			System.out.println(linkText);
		}
		
	}

}
