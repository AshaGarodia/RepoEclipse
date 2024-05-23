package JavaSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFilesUsingChrome {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();

driver.manage().window().maximize();

Thread.sleep(2000);

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

}

}
