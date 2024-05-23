package JavaSessions;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.Assert;
import org.openqa.selenium.By;

//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Udemy_Assessment2 {

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

driver.get("https://rahulshettyacademy.com/angularpractice/");

driver.findElement(By.name("name")).sendKeys("Asha Garodia");

driver.findElement(By.name("email")).sendKeys("agarodia.techark@gmail.com");

driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");

Thread.sleep(2000);


driver.findElement(By.cssSelector("input[id ='exampleCheck1']")).click();

driver.findElement(By.xpath("//select[@class = 'form-control'] //option[1]")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("//input[@id = 'inlineRadio1']")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("//input[@name = 'bday']")).sendKeys("07/12/1988");

Thread.sleep(2000);

driver.findElement(By.xpath("//input[@type= 'submit']")).click();

driver.close();
		


	}

}
