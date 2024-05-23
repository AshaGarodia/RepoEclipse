package JavaSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomConcept {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.ebay.com/");
        
        driver.manage().window().maximize();

        Thread.sleep(3000);
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        String zoomType = ("document.body.style.zoom = '50%'");
        js.executeScript(zoomType);
        
        Thread.sleep(3000);
 driver.close();
        
	}

}
