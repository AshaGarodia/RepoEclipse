package JavaSessions;
//import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CalendarControl {
	
	public static WebDriver dr;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\.eclipse\\chromedriver-win64\\chromedriver.exe");
		dr = new ChromeDriver();
		
		dr.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		dr.findElement(By.id("datepicker")).click();
		
		WebDriverWait wait = new WebDriverWait(dr,5);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		
		String MonthYearVal = dr.findElement(By.className("ui-datepicker-title")).getText();
		
		System.out.println(MonthYearVal);
		
		selectDate("30","June","2025");
		
		//splitting the month and year by space and storing them separately in 2 variables.
		
		//String month = MonthYearVal.split(" ")[0].trim();
		//String year  = MonthYearVal.split(" ")[1].trim();
		
		//System.out.println(month);
		//System.out.println(year);
		
		//public static String[] getMonthYear(String MonthYearVal) {
		//	return MonthYearVal.split(" ");
		//}
		
		//public static void selectDate(String exDay, String exMonth, String exYear) {
			//String MonthYearVal = dr.findElement(By.className("ui-datepicker-title")).getText();
			//while (!(getMonthYear(MonthYearVal)[0].equals(exMonth)
				//	&&
					//getMonthYear(MonthYearVal)[1].equals(exYear)))	
					//{
				//dr.findElement(By.xpath("//a[@title='Next']")).click();
				
				//MonthYearVal = dr.findElement(By.className("ui-datepicker-title")).getText();
				
			//	System.out.println(MonthYearVal);
				
			//	month = MonthYearVal.split(" ")[0].trim();
			//	year  = MonthYearVal.split(" ")[1].trim();
		//}
		
			//dr.findElement(By.xpath("//a[text()='+exDay']")).click();	
	}
	 
		
	public static String[] getMonthYear(String MonthYearVal) {
		return MonthYearVal.split(" ");
	}
	
	public static void selectDate(String exDay, String exMonth, String exYear) {
		
		if(exMonth.equals("February") && (Integer.parseInt(exDay)>29)) {
			System.out.println("Wrong date: " + exMonth + ":" + exDay );
			return;
		}
		

		if (Integer.parseInt(exDay)>31){
			System.out.println("Wrong date: " + exMonth + ":" + exDay );
			return;
		}
		
		String MonthYearVal = dr.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(MonthYearVal);
		while (!(getMonthYear(MonthYearVal)[0].equals(exMonth)
				&&
				getMonthYear(MonthYearVal)[1].equals(exYear)))	
				{
			dr.findElement(By.xpath("//a[@title='Next']")).click();
			
			MonthYearVal = dr.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(MonthYearVal);
			
		//	month = MonthYearVal.split(" ")[0].trim();
		//	year  = MonthYearVal.split(" ")[1].trim();
	}
	
		try {
			dr.findElement(By.xpath("//a[text()='"+exDay+"']")).click();	
		} catch (Exception e) {
			System.out.println("Wrong date: " + exMonth + ":" + exDay );
		}

}
 
}	
		
	

