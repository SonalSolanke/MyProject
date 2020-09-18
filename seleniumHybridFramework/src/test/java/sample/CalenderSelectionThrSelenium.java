package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectionThrSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[2]/td[7]
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[5]/td[3]
		
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class= 'picker-first2' and @id='']//button[@class='ui-datepicker-trigger']")).click();
		
		//driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[3]")).click();
		
		String beforeXpath= "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[";
		String afterXpath= "]/td[";
		
		String myDate= "30/09/2020";
		String dateArr[]=myDate.split("/");
		//System.out.println(dateArr[0]);
		String day=dateArr[0];
		
		int maxRowNum= 6;
		int maxColNum= 7;
		String dayVal= null;
		WebElement ele;
		boolean flag=false;
		
		for(int row=1; row<maxRowNum; row++)
			
		{
			for(int col=1; col<=maxColNum; col++)
			{
				try 
				{
					
				ele= driver.findElement(By.xpath(beforeXpath + row + afterXpath + col + "]" ));
				dayVal= ele.getText();
				}
				catch(NoSuchElementException e)
				{
					
					System.out.println("Invalid date entered. Please enter valid date");
					flag=false;
					break;
				}
				
				if(dayVal.equals(day))
				{
					ele.click();
					flag=true;
					break;
				}
				
			}
			
			if(flag)
			{
				break;
			}
			
			
		}
		
		
		
		
	}

}
