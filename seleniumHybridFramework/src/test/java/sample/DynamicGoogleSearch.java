package sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");

		
		List<WebElement> searchItems= driver.findElements(By.xpath("//div[@class='aajZCb']/ul/li/div/div[2]/div[1]/span"));
		System.out.println("no of seraches:  " + searchItems.size());
		for(WebElement ele:searchItems)
		{
		
			if(ele.getText().equalsIgnoreCase("testing types"))
			{			
				ele.click();
				break;
			}
			
			
		}
		

	}

}
