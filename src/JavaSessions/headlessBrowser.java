package JavaSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headlessBrowser {

	public static void main(String[] args) {
		
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--headless"); // Set the browser in headless mode
		        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver(options);
		        
		       System.out.println("This is for testing headless browser");
		        
		      driver.quit(); // Remember to quit the driver to close the browser
		    
		
		
		
	}

}
