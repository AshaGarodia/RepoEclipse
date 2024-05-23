package JavaSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileUsingFirefox {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true); //only for pdf file
				
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
		
			System.setProperty("webdriver.firefox.marionette","C:\\Users\\pc\\Downloads\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().deleteAllCookies();

		 driver.manage().window().maximize();

		 Thread.sleep(3000);
			 
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		
		//Download text file

		driver.findElement(By.id("textbox")).sendKeys("This is for testing the download file behavior for text files");

		Thread.sleep(3000);

		driver.findElement(By.id("createTxt")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("link-to-download")).click();

		//Download pdf file

		driver.findElement(By.id("pdfbox")).sendKeys("This is for testing the download file behavior for pdf files");

		driver.findElement(By.id("createPdf")).click();

		driver.findElement(By.id("pdf-link-to-download")).click();


		driver.quit();
	}

}
