package JavaSessions;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
//import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWaitTest {

	private static final TimeUnit SECONDS = null;

	public static void main(String[] args)  {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

driver.findElement(By.xpath("//div[@id='start']//button")).click();

Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
.withTimeout(30,SECONDS)  // Maximum amount of time to wait
.pollingEvery(2,SECONDS)   // Frequency of checking the condition
.ignoring(NoSuchElementException.class);

WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {

public WebElement apply(WebDriver driver) {
	if (driver.findElement(By.xpath("//div[@id='finish']//h4")).isDisplayed())
{
		return driver.findElement(By.xpath("//div[@id='finish']//h4"));
}
else
{
	return null;
}

	}

});

System.out.println(driver.findElement(By.xpath("//div[@id='finish']//h4")).getText());

driver.close();
}
}