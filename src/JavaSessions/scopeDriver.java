package JavaSessions;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scopeDriver {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      
     // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //find all links in the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //find all links in the footer
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //find all links in the first column of the footer
        WebElement columndriver = footerdriver.findElement(By.xpath("//table//tbody//tr//td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //Opens all the tabs
        for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++)
        {
        String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        Thread.sleep(2000);
        }
        //Iterates through all the tabs and provides the window titles
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        while(it.hasNext())
        {
        driver.switchTo().window(it.next());
        System.out.println(driver.getTitle());
        }

        }

        }
