package JavaSessions;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Udemy_Assessment1 {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

driver.get("https://rahulshettyacademy.com/AutomationPractice/");

driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).isSelected();

Assert.assertFalse(driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).isSelected());

System.out.println(driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).isSelected());

driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).click();

Assert.assertTrue(driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).isSelected());

System.out.println(driver.findElement(By.cssSelector("input[id ='checkBoxOption1']")).isSelected());

//Count for number of checkboxes

System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

driver.close();


	}

}
