package JavaSessions;
//import java.io.File;
//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutor {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver-v0.34.0-win-aarch64.exe");
			WebDriver driver = new FirefoxDriver();
		
		 driver.manage().window().maximize();

		 driver.manage().deleteAllCookies(); 
		  
		 driver.get("https://www.ebay.com/");

		 Thread.sleep(2000);

	//	 driver.findElement(By.name("userid")).sendKeys("agarodia.techark@gmail.com");

		//WebElement loginbtn = driver.findElement(By.name("signin-continue-btn"));

	//	highlight(loginbtn,driver);  //Highlight any element
//		drawBorder(loginbtn,driver);   //Draw a border around any element
		
		//Take a screenshot and store as a file format
		
	//	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(src, new File("C:\\Users\\pc\\Eclipse Screenshots\\element.png"));
		
		//Calling the Generate alert custom method
		
		// generateAlert(driver, "There is an error with the login button on the landing page. Therefore it has also been highlighted");
		
		//Click any element using JS
		
		//clickElementbyJS(loginbtn,driver);
		
	//	Thread.sleep(2000);
		
		refreshBrowserByJS(driver);
		
	//	getTitleByJS(driver);
		
	//	getInnerPageTextByJS(driver);
		
	//	Thread.sleep(2000);
		
		scrollPageDownbyJS(driver);
		
		WebElement RegLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
		scrollIntoView(RegLink,driver);
		
		
		driver.close();
	 }

		public static void highlight(WebElement element, WebDriver driver) {
		 String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i<15; i++) {
		changeColor("rgb(0,200,0)",element, driver);
		changeColor(bgcolor,element, driver);
		 }
}

		public static void changeColor(String color, WebElement element, WebDriver driver) {
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("arguments[0].style.backgroundColor = '"+color+"'" , element);
}

		public static void drawBorder(WebElement element , WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border = '3px solid red'", element);
		}
		
		public static void generateAlert(WebDriver driver, String message) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("alert('"+message+"')");
		}
		
		public static void clickElementbyJS(WebElement element , WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", element);
		}
		
		public static void refreshBrowserByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("history.go(0)");
		}
		
		public static String getTitleByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		}
		
		public static String getInnerPageTextByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
		}
		
		public static void scrollPageDownbyJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight");
		}
		
		public static void scrollIntoView(WebElement element , WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}


