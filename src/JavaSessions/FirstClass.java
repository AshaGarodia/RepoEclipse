package JavaSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public static void main(String[] args) {


//System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
// WebDriver driver = new FirefoxDriver();
//driver.close();
 
 System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chrome-win64\\chrome.exe");
 WebDriver dr = new ChromeDriver();
 dr.close();
	}

}
