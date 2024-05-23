package JavaSessions;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleChatbot {

	public static void main(String[] args) {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

driver.get("https://www.lg.com/in/");



driver.findElement(By.xpath("//div[@class= 'al-quick-btn__quickbtn al-quick-btn__quickbtn--animation']")).click();

System.out.println("Found the chatbot");

driver.findElement(By.xpath("//button[@class= 'al-quick-btn__quickbtn']")).click();


//if(element.size()>0)
//{
	//element.get(0).click();
	//System.out.println("Closing the chatbot");
//}
	}

}
