package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionDemo {
	WebDriver driver;
	
	@Test
	public void googleTC()
	{
		System.out.println("googleTC  "+ Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver","F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void fbTC()
	{
		System.out.println("fbTC  "+ Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver","F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}

}
