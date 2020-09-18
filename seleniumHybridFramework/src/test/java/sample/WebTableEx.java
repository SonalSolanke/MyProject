package sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebTableEx {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//WebDriver driver= new HtmlUnitDriver();
		driver.get("http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/");
		
		/*
		
		//Print all headers of web table:
		List<WebElement> headers= driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr[1]/th"));
			
		System.out.println("tital headers are : " +headers.size());
		System.out.println("headers:  ");
		for(WebElement header: headers)
		{
			System.out.print(header.getText() + "  ");
			
		}
		
		
		// Retrieve and print number of rows and realsted coumns for rows in a web table:
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));
		int numRow= rows.size();
		System.out.println("no of rows:  " +  (numRow-1) );
		
		for(int i=2; i<=numRow; i++)
		{
			List<WebElement> ColumnPerRow = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td"));
			System.out.println("columns under " + i + "row is: " + ColumnPerRow.size());
			
			System.out.println("Coumns are : ");
			for(WebElement column :ColumnPerRow )
			{
				
				System.out.print(column.getText()  + "  ");
			}
			System.out.println();
			
		}
		
		
		//Retrieve name of book whose author is Mukesh
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));

		System.out.println("Book Names with author= Mukesh : ");
		for(int i=2; i<=rows.size(); i++)			
		{
				
			WebElement authorCol = driver.findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td[2]"));
			WebElement bookNameCol = driver.findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td[1]"));
			
			
			if(authorCol.getText().equalsIgnoreCase("Mukesh"))

				System.out.println(bookNameCol.getText());
				
		
			
		}
		
		
		
		//List all books whose price is greater than or equal to 1000
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));
		
		System.out.println("Book Names with price >=  1000 : ");
		for(int i=2; i<=rows.size(); i++)
		{
			WebElement price= driver.findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td[4]"));
			WebElement bookNameCol = driver.findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td[1]"));
			
			if(Integer.parseInt(price.getText()) >= 1000)
			{
				System.out.println(bookNameCol.getText() + " - with price - " + price.getText());
				
				
			}
			
		}


		
		//Print last row of table
		
		System.out.println("Last row of table: ");
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));
			
		for(int i=2; i<=rows.size(); i++)
		{
			if(i== rows.size())
			{
				List<WebElement> ColumnPerRow = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td"));
				
				for(WebElement column :ColumnPerRow )
				{
					
					System.out.print(column.getText()  + "  ");
				}
	
			}
							
		}
	
	
		
	
		
		//Print total cost of all books listed in table
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));
		int sum= 0;
		System.out.println("Sum of Price of all books : ");
		for(int i=2; i<=rows.size(); i++)
		{
			List<WebElement> price= driver.findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td[4]"));
			
			for(WebElement p:price )
			{
			  sum= sum + (Integer.parseInt(p.getText()));
				
			}
			
			
		}
		
		System.out.println(sum);
		
		
		*/
		
		
		//Retrieving cell value of specific column of specific row
		WebElement rows = driver.findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr[3]/td[3]"));
		System.out.println("cell value is : " + rows.getText());
		
		
		
		driver.quit();

	}

}
