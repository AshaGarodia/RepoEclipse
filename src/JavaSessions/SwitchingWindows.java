package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

driver.get("https://demo.automationtesting.in/Windows.html");

driver.findElement(By.xpath("//li[@class='active']//a[@class='analystic']")).click();

driver.findElement(By.xpath("//a//button[@class='btn btn-info']")).click();

System.out.println("Current window is "+ driver.getTitle());





	}

}
