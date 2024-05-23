package JavaSessions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSortingCheck {

	public static void main(String[] args) throws InterruptedException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

Thread.sleep(3000);

driver.get("https://testautomationpractice.blogspot.com/");

driver.manage().window().maximize();

WebElement element = driver.findElement(By.id("country"));
Select se = new Select(element);

List<String> originalList = new ArrayList();

List<String> tempList = new ArrayList();

List <WebElement>options = se.getOptions();

for(WebElement e:options)
{
	originalList.add(e.getText());
	tempList.add(e.getText());
}
System.out.println(originalList);


//tempList = originalList;

System.out.println("Before sorting, the list is " +originalList);

Collections.sort(tempList);

System.out.println("After sorting, the list is " +tempList);

if(originalList==tempList)
{
	System.out.println("Dropdown is sorted");
}
else
{
	System.out.println("Dropdown is not sorted");
	}


driver.close();

	}

}
