package JavaSessions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GooglePageSpeedScoresUsingAPI {

			    public static void main(String[] args) {
		        // Set the path to ChromeDriver executable
			    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
		        // Initialize ChromeDriver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // URLs to test
		            String[] urls = {"https://franklinsouthampton.tekark.com/", "https://franklinsouthampton.tekark.com/property-search/"};

		            for (String url : urls) {
		                // Get scores using PageSpeed Insights API
		            	
		            	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		    			 
		    			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    			 
		                String desktopScore = getPageSpeedScore(url, "desktop");
		                String mobileScore = getPageSpeedScore(url, "mobile");

		                // Print scores
		                System.out.println("URL: " + url);
		                System.out.println("Desktop Score: " + desktopScore);
		                System.out.println("Mobile Score: " + mobileScore);
		            }

		        } finally {
		            // Close the WebDriver
		            driver.quit();
		        }
		    }

		    public static String getPageSpeedScore(String url, String strategy) {
		       
		    	
		    String apiKey = "AIzaSyArqcovUCWSJoxwXDDSr6EE5qzQGWwKBOA"; // Replace with your PageSpeed Insights API key
		        String apiUrl = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed?url=" + url + "&strategy=" + strategy + "&key=" + apiKey;

		        try {
		            URL urlObj = new URL(apiUrl);
		            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
		            conn.setRequestMethod("GET");

		            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		            StringBuilder response = new StringBuilder();
		            String line;
		            while ((line = reader.readLine()) != null) {
		                response.append(line);
		            }
		            reader.close();

		            // Parse JSON response using Gson
		            JsonElement root = JsonParser.parseString(response.toString());
		            JsonObject jsonObject = root.getAsJsonObject();

		            return jsonObject.getAsJsonObject("lighthouseResult")
		                    .getAsJsonObject("categories")
		                    .getAsJsonObject("performance")
		                    .get("score")
		                    .getAsString();

		        } catch (IOException e) {
		            e.printStackTrace();
		            return "N/A";
		        }
		    }
		}


	


