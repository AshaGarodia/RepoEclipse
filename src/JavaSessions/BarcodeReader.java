package JavaSessions;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.Result;


public class BarcodeReader {

	public static void main(String[] args) throws IOException {
		
		// Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
     // Initialize ChromeDriver
WebDriver driver = new ChromeDriver();

driver.get("https://barcode.tec-it.com/en");

String barcodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
System.out.println(barcodeURL);

URL url = new URL(barcodeURL);

BufferedImage bufferImage = ImageIO.read(url);

LuminanceSource luminanceSource = new LuminanceSource(bufferImage);

BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

Result result = new MultiFormatReader().decode(binaryBitmap);

System.out.println(result.getText());

}

}
