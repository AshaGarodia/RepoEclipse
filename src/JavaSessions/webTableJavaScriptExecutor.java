package JavaSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	   
	    driver.manage().deleteAllCookies(); 
	     
	    driver.manage().window().maximize();
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0,500)");
	    
	    Thread.sleep(3000);
	    
	    js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	    	    
	    List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	    Integer sum = 0;
	    for(int i=0; i<values.size();i++)
	    {
	    	
	    	sum = sum + (Integer.parseInt(values.get(i).getText()));
	    	
	    }
	    
	    System.out.println("The sum of amount values is " +sum);
	    
	    
	   String amount = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
	   
	  int total = Integer.parseInt(amount.split(": ")[1].trim( ));
	  	
	  if(total==sum)
	  {
		  System.out.println("The values are same");
		  	  
	  }
	  else
	  {
		  System.out.println("The values are not same");
	  }
    	
	    driver.close();       

	}

}
