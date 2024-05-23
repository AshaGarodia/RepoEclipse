package JavaSessions;

//import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//import java.util.*;
import org.openqa.selenium.WebElement;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamDemo {

	public static void main(String[] args) throws InterruptedException {

		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr//span[contains(text(),'Veg/fruit name')]")).click();
		
		List<String> price;
		
		do
			{
			
			List<WebElement> vegetables = driver.findElements(By.xpath("//tr//td[1]"));
			
			List<String> originalList= vegetables.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList =	originalList.stream().sorted().collect(Collectors.toList());
		
		sortedList.forEach(s->System.out.println(s));
		
		//Assert.assertTrue(originalList.equals(sortedList));
		
		//Scan the vegetable list and map to a custom method
		
		price = vegetables.stream().filter(s->s.getText().contains("Rice")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		if (price.size()<1)
		{
		
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
    	}

		}while(price.size()<1);
		
		price.forEach(s->System.out.println(s));
		
	//	System.out.println(price);
	//	driver.close();
		
	}
	private static String getPriceVeggie(WebElement s) 
	{
	
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
	

