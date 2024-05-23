package JavaSessions;

  
		    import java.util.HashMap;

		    import java.util.Map;

		    import org.openqa.selenium.Proxy;

		    import org.openqa.selenium.WebDriver;

		    import org.openqa.selenium.chrome.ChromeDriver;

		    import org.openqa.selenium.chrome.ChromeOptions;

		    import org.openqa.selenium.edge.EdgeOptions;

		    import org.openqa.selenium.firefox.FirefoxOptions;

		    public class sslCheck {

		    public static void main(String[] args) {

		    // TODO Auto-generated method stub

		    ChromeOptions options = new ChromeOptions();

		    Proxy proxy = new Proxy();

		    proxy.setHttpProxy("ipaddress:4444");

		    options.setCapability("proxy", proxy);

		    Map<String, Object> prefs = new HashMap<String, Object>();


		    prefs.put("download.default_directory", "/directory/path");


		    options.setExperimentalOption("prefs", prefs);

		   options.setAcceptInsecureCerts(true);

		   System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver(options);

		    driver.get("https://expired.badssl.com/");

		    System.out.println(driver.getTitle());


		    
		    
	}

}
