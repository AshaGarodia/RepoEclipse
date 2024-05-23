package JavaSessions;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.file.File;

//import org.openqa.selenium.WebDriver.Timeouts;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PdfReader {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

String downloadPath = System.getProperty("user.dir");
System.out.println("The download path to be set is " +downloadPath);

ChromeOptions options = new ChromeOptions();
Map<String,Object> prefs = new HashMap<String,Object>();
prefs.put("download.default_directory","downloadPath");
options.setExperimentalOption("prefs", prefs);

driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

driver.get("https://invoiceto.me/");

driver.findElement(By.xpath("//input[@id='title']")).clear();
driver.findElement(By.xpath("//input[@id='company']")).clear();

driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Testing PDF");
driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Test Company");

driver.findElement(By.xpath("//*[@id=\"open_pp\"]")).click();

driver.findElement(By.xpath("//a[contains(@class,'cta generate_pdf')]")).click();

downloadPath = "C:\\Users\\pc\\eclipse-workspace\\JavaTraining\\DataFiles\\invoiceto.me.pdf" ;

File file = new File(downloadPath);

FileInputStream fis = new FileInputStream(file);

PDDocument document = Loader.loadPDF(file);

String pdfData = new PDFTextStripper().getText(document);

System.out.println("The pdf data is  " +pdfData);

fis.close();

driver.close();




	}

}
