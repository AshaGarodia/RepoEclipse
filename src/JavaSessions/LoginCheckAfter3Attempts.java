package JavaSessions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCheckAfter3Attempts {

	static String ErrorMessage;
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
        driver = new ChromeDriver();
    	driver.get("http://gcreddy.com/project/admin/login.php");

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(3000);

FileReader file = new FileReader(".\\DataFiles\\input.txt");
BufferedReader br = new BufferedReader(file);

int count = 0;
int iteration = 0;
String line;

while((line=br.readLine())!= null)
{
	count = count + 1;
	if(count>1)
	{
		System.out.println("Check..check");
		
		iteration = iteration+1;
		
		String inputData[] = line.split(",", 2);
		
		System.out.println("inputData[0]");
		System.out.println("inputData[1]");
		

	
	System.out.println("Check..check");
	
driver.findElement(By.name("username")).sendKeys(inputData[0]);
driver.findElement(By.name("password")).sendKeys(inputData[1]);
	
//	driver.findElement(By.name("username")).sendKeys("abcd");
//driver.findElement(By.name("password")).sendKeys("abcd@123");
		

driver.findElement(By.id("tdb1")).click();

Thread.sleep(2000);

ErrorMessage= driver.findElement(By.className("messageStackError")).getText();

if ((iteration == 4) && (ErrorMessage.contains("Error: The maximum number of login attempts has been reached. Please try again in 5 minutes."))) 
{
System.out.println(iteration+ "Maximum invalid login attempts are over – Passed");
}
else if ((iteration <= 3) && (ErrorMessage.contains("Error: Invalid administrator login attempt."))) 
{
System.out.println(iteration+ "Maximum invalid login attempts are Not over – Passed");
}
else
{
System.out.println(iteration+ "Failed");
}
driver.close();
}
}
br.close();
file.close();

		
	}
}


