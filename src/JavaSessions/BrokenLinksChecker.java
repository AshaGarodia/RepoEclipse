package JavaSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

//import java.io.IOException;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.testng.asserts.SoftAssert;
//import org.junit.Assert;

public class BrokenLinksChecker {
    public static void main(String[] args) {
        
    System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
   
    driver.manage().deleteAllCookies(); 
     
    //driver.manage().deleteCookieNamed("abc");
    
    //driver.manage().addCookie(null);
    
     driver.manage().window().maximize();
     
      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
    driver.get("https://cadca.tekark.com/");

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Set<String> uniqueLinks = new HashSet<>();

      //  SoftAssert a = new SoftAssert();
        
        // Iterate through each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty() && !uniqueLinks.contains(url) && !url.contains("javascript")) {
                try {
                    // Create a HttpURLConnection
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    // Set the request method
                    connection.setRequestMethod("HEAD");
                    // Connect to the URL
                    connection.connect();
                    // Get the response code
                    int responseCode = connection.getResponseCode();
                    // Check if the response code is not 200 (OK)
                    if (responseCode >= 400) {
                        System.out.println("Broken Link: " + url + " - Response Code: " + responseCode);
                    } else {
                        System.out.println("Valid Link: " + url);
                    }
                    uniqueLinks.add(url);
                } 
                catch (Exception e)
                {
                    System.out.println("Error occurred while checking link " + url + ": " + e.getMessage());
                }
            }
        }

        // Close the browser
      driver.close();
    }
}