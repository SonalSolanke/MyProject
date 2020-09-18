package sample;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnAutomationWork {

	public static void main(String[] args) throws IOException, EmailException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		sendEmail();

		
		/*
		
		int frames_size= driver.findElements(By.tagName("iframe")).size();
		
		
		Alert alt= driver.switchTo().alert();
		alt.accept();
		alt.dismiss();
		alt.getText();
		alt.sendKeys("abd");
		
		
		//check dropdown values Sorted or not 
		
		driver.get("http://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		
		WebElement tools= driver.findElement(By.id("tools"));
		Select sel_tools= new Select(tools);
		
		List<WebElement> list_tools= sel_tools.getOptions();
		
		List actualListTools= new ArrayList();
		
		for(WebElement ele: list_tools) {
			
			String data= ele.getText();
			actualListTools.add(data);
			
		}
		
		List SortedListTools= new ArrayList();
		SortedListTools.addAll(actualListTools);
		
		Collections.sort(SortedListTools);
		
		Assert.assertTrue(actualListTools.equals(SortedListTools));
		
		System.out.println("tools Sorted ");
		
		
        TakesScreenshot ts= (TakesScreenshot)driver;
		
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		File destination= new File("F:\\aaaaSelenium coaching\\chromedriver_win32\\abc.png"); 
		
		FileUtils.copyFile(source, destination);
		
		System.out.println("captured");
	
		
		
		WebElement tools1= driver.findElement(By.id("tools1"));
		Select sel_tools1= new Select(tools1);
		
		List<WebElement> list_tools1= sel_tools1.getOptions();
		
		List actualListTools1= new ArrayList();
		
		
		for(WebElement ele1: list_tools1) {
			
			String data1= ele1.getText();
			actualListTools1.add(data1);		
			
		}
		
		
		List SortedListTools1= new ArrayList();
		SortedListTools1.addAll(actualListTools1);
		
		
		Collections.sort(SortedListTools1, Collections.reverseOrder());
		
		Assert.assertTrue(SortedListTools1.equals(actualListTools1));
		System.out.println("tools1 sorted");
		
		
		
		driver.quit();
		
		
		
		
		
		/*
		
		\\dropdowns
		driver.get("https://www.facebook.com/");
		
		WebElement day_dd= driver.findElement(By.name("birthday_day"));
		
		Select day_select= new Select(day_dd);
		
		String first_selected= day_select.getFirstSelectedOption().getText();
		
		System.out.println(first_selected);
		day_select.selectByVisibleText("17");
		
		String Next_selected= day_select.getFirstSelectedOption().getText();
		System.out.println(Next_selected);
		
		Assert.assertEquals(Next_selected, "17");
		System.out.println("pass");
		
		List<WebElement> ddList= day_select.getOptions();
		
		int dayOption_size= day_select.getOptions().size();
		System.out.println(dayOption_size);
		
		for(int i=1; i<=dayOption_size; i++) {
			String str= ddList.get(i).getText();
			System.out.println("opts: " +str );
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//radio btn- dynamic
		
		List<WebElement> radio_Btn= driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		
		System.out.println("size is :" + radio_Btn.size());
		
		for(WebElement ele:radio_Btn ) {
			
			String str= ele.getAttribute("value");
			System.out.println("Radio Btns are: " + str);
			
			
			if(str.equalsIgnoreCase("Ruby")) {
				ele.click();
				
				
			}
			
		}
		
		
		*/
		

	}

	public static void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("pravin.vsp1@gmail.com");
		email.setSubject("TestMail from Sonal");
		email.setMsg("test mail from sonal... :-)");
		email.addTo("solanke.sonal@gmail.com");
		email.send();
	}

}
