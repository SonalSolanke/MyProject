package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectionByJS {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		String setDate= "16/09";
		WebElement fromDate= driver.findElement(By.xpath("//input[@id= 'ctl00_mainContent_view_date1']"));
		//WebElement fromDate= driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		setCalenderDateByJS(driver, fromDate,setDate);
		
	}
	
	
	public static void setCalenderDateByJS(WebDriver driver, WebElement element, String setDate)
	{
		
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].setAttribute('value','"+setDate+"');", element);
	}
	
	

}
