
package JavaSessions;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorConcepts {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
		WebDriver driver = new FirefoxDriver();
		
 //System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chrome-win64\\chrome.exe");
 //WebDriver dr = new ChromeDriver();
 
		driver.get("https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fcart%2Fview.html%3Fref_%3Dnav_ya_signin&prevRID=FZ77NDMRE22H7VVTBE8Q&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
 
 //1.By Xpath
 
// driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Asha Garodia");
// driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("agarodia.techark@gmail.com");
 
 
 //2.By ID
 
	//	driver.findElement(By.id("ap_customer_name")).sendKeys("Asha Garodia");
	//	driver.findElement(By.id("ap_email")).sendKeys("agarodia.techark@gmail.com");
		
//3. By name
		
		driver.findElement(By.name("customerName")).sendKeys("Taksheel Agrawal");
		driver.findElement(By.name("email")).sendKeys("taksheel@yopmail.com");
		
	//	driver.findElement(By.id("ap_password")).sendKeys("Test@1234");
	//	driver.findElement(By.id("ap_password_check")).sendKeys("Test@1234");
		
// 4. How to use linktext : used to click links
		
		//driver.findElement(By.linkText("continue")).click();
		
// 5. How to use partial link text : not useful and not recommended to use. Partial link text can be passed for this.
		
	//	driver.findElement(By.partialLinkText("Some part of the long text")).click();
		
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("Test@1234");
		driver.findElement(By.cssSelector("#ap_password_check")).sendKeys("Test@1234");
		
		driver.findElement(By.id("continue")).click();
		 
	}
	
}