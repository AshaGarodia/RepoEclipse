package JavaSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class testScreenshot {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://www.dominionterminal.com/");

        // Take full-page screenshot
        Thread.sleep(3000);
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        // Save screenshot to a file
        try {
            ImageIO.write(screenshot.getImage(),"PNG", new File(".\\Images\\full_page_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();                      
        }

        // Close the WebDriver
        driver.quit();
    }
}