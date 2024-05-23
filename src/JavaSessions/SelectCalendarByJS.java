package JavaSessions;
import java.util.HashMap;
import java.util.Map;
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectCalendarByJS {
	//public static WebDriver dr;
	public static void main(String[] args) {
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();
		    
		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
		    
		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		WebDriver dr = new ChromeDriver(options);
		
	//	ChromeOptions options = new ChromeOptions();
		
	//	options.addArguments("--disable-notifications");
		
	//	options.addArguments("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
		
		//WebDriver dr = new ChromeDriver(options);
		
		
		
		//dr = new ChromeDriver();
		
		//dr.manage().deleteAllCookies(); 
		 
		// dr.manage().window().maximize();
		 
		// dr.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	
		
		dr.get("https://www.spicejet.com/");
		
		//Actions().sendKeys(Keys.ESCAPE).build().perform();
		
	//  dr.switchTo().alert().accept();
		
		WebElement date = dr.findElement(By.className("css-76zvg2 css-bfa6kz r-homxoj r-ubezar"));
		
		String dateVal = "30-Dec-2024";
		
		selectDateByJS(dr,date,dateVal);
		
	}
	
private static WebElement Actions() {
		// TODO Auto-generated method stub
		return null;
	}

public static void 	selectDateByJS(WebDriver dr,WebElement date,String dateVal) {
	JavascriptExecutor js = ((JavascriptExecutor) dr);
	js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", date);
}

}
