package JavaSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduledCronJob {

		public static void main(String[] args) {
	
			try {
		            // Create a Quartz Scheduler instance
		            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		            
		            // Start the scheduler
		            scheduler.start();

		            // Define the job and tie it to our MonthlySeleniumJob class
		            JobDetail job = JobBuilder.newJob(SeleniumJob.class)
		                    .withIdentity("seleniumJob", "group1")
		                    .build();

		            // Define a Trigger that will fire "monthly" on a specific date
		            Trigger trigger = TriggerBuilder.newTrigger()
		                    .withIdentity("monthlyTrigger", "group1")
		                    .startNow()
		                    .withSchedule(
		                            CronScheduleBuilder.monthlyOnDayAndHourAndMinute(2, 17, 30) // Run on the 1st day of each month at midnight
		                    )
		                    .build();

		            // Schedule the job with the trigger
		            scheduler.scheduleJob(job, trigger);

		        } 
					        catch (SchedulerException e) 
					        {
		                           e.printStackTrace();
		                   }
		    }

		    // Job class where you define the Selenium actions to be performed
		    public static class SeleniumJob implements Job {
		        public void execute(JobExecutionContext context) throws JobExecutionException {
		            // Instantiate Chrome browser driver
		        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		            WebDriver driver = new ChromeDriver();

		            // Navigate to a website and perform actions
		            driver.get("https://rhonda.tekark.com/");
		            // Add your Selenium script actions here

		            // Close the browser
		            driver.quit();
		        }
		        
		    }
		

	}




