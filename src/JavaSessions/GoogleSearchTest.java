package JavaSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		
		dr.get("https://www.google.com/");
		
		dr.findElement(By.name("q")).sendKeys("Java ");
		
		List<WebElement> list = dr.findElements(By.xpath("//ul[@role='presentation']//li/descendant::div[@class='wM6W7d']"));
		
		System.out.println("Total number of Suggestions for Google Search are..>>" +list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		

		
	}

}
