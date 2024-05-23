package JavaSessions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ImplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		clickOn(driver,driver.findElement(By.xpath("//input[contains(@class,'btn btn-prim gh-spr')]")),20);
			}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
