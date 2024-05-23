package JavaSessions;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieHandling {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();

Thread.sleep(3000);

driver.get("https://www.amazon.in/");

//Retrieve all the cookies from the browser
Set <Cookie> cookies = driver.manage().getCookies() ;

//Prints the size of cookies in the browser
System.out.println("Size of cookies is "+cookies.size());


for(Cookie cookie:cookies)         //read and print all the cookies
{
	System.out.println(cookie.getName()+ ":" +cookie.getValue());
}

//Adding new cookie

Cookie cobj = new Cookie("mycookie","1234567890");

driver.manage().addCookie(cobj);


//Retrieve all the cookies from the browser
Set <Cookie> cookiesNewSize = driver.manage().getCookies() ;

//Prints the size of cookies in the browser
System.out.println("Size of cookies is "+cookiesNewSize.size());

for(Cookie cookie:cookiesNewSize)     //read and print all the cookies
{
	System.out.println(cookie.getName()+ ":" +cookie.getValue());
}

driver.manage().deleteCookie(cobj);

System.out.println("After deletion of cookie....");

//Retrieve all the cookies from the browser
Set <Cookie> cookiesNewSizeAfterDelete = driver.manage().getCookies() ;

//Prints the size of cookies in the browser
System.out.println("Size of cookies is "+cookiesNewSizeAfterDelete.size());

driver.manage().deleteAllCookies();
System.out.println("After deletion of all cookies....");

//Retrieve all the cookies from the browser
Set <Cookie> cookiesNew = driver.manage().getCookies() ;

//Prints the size of cookies in the browser
System.out.println("Size of cookies is "+cookiesNew.size());

driver.close();

	}

}
