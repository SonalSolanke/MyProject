package com.seleniumHybridFramework.testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dummy {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\aaaaSelenium coaching\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		
		//highlight element
		driver.get("https://www.toolsqa.com/");
		
        WebElement ele= driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div/div[1]/div/h2/span"));
		
        scrollToElementByJS(driver, ele);
		
		
		
		
		/*
			
	    String pageTitle= getTitleByJS(driver);
		System.out.println("Page title : " +pageTitle );
		
		String pageText= getPageTextByJS(driver);
	    System.out.println("Page title : " +pageText );
		/*
		WebElement ele= driver.findElement(By.xpath("//*[@id=\"cookie_action_close_header\"]"));
		
		highlight(driver, ele);
		
		drawBorder(driver,ele);
		
		generateAlertForIssue(driver,"Issue Observed at highlighted element");
		
		Alert alert= driver.switchTo().alert();
		alert.accept();
			
		clickOnElementByJS(driver, ele);
		
		refreshBrowserWithJS(driver);  //not mostly used
		
		/*
		//WebDriver driver= new ChromeDriver();
		WebDriver driver= new HtmlUnitDriver();
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//browser pop ups
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		Thread.sleep(5000);
		
		
		
		Set<String> handle= driver.getWindowHandles();
		
		Iterator<String> it = handle.iterator();
		String parentWindowHandler= it.next();
		System.out.println("Parent Window Handler " + parentWindowHandler );
		Thread.sleep(5000);
		String childWindowHandler= it.next();
		System.out.println("Child Window Handler " + childWindowHandler);
		
	    driver.switchTo().window(childWindowHandler);
	    Thread.sleep(5000);
	    
	    System.out.println("Child window title:  " + driver.getTitle());
	    
		driver.close();
		
		driver.switchTo().window(parentWindowHandler);
		Thread.sleep(5000);
		System.out.println("Parent window title : " + driver.getTitle());
		driver.quit();
	    
	    
		/*
		driver.get("https://html.com/input-type-file/");
		
		//driver.navigate().back();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("fileupload")).sendKeys("F:\\aaaaSelenium coaching\\Installations\\settings.xml");
		

		//driver.navigate().to("");
		clickOn(driver, driver.findElement(By.xpath("//input[@type='submit']")), 30);
		
		/*F:\aaaaSelenium coaching\Installations
		
		
		
		
		Alert alert= driver.switchTo().alert();
		String alertText= alert.getText();
		
		System.out.println("Text in Alert is : " + alertText);
		if(alertText.equals("Alert string"))
		{
			System.out.println("Accept alert");
			
		}
		else
			System.out.println("dismiss alert");
		
		alert.accept();
		
		alert.dismiss();
		
/*
		System.setProperty("webdriver.chrome.driver",rc.getChromeBrowserPath());
		driver= new ChromeDriver();	
		
		driver.get("http://demo.guru99.com/v4/manager/addcustomerpage.php");
		Thread.sleep(5000);
		
		
		int linksCount= driver.findElements(By.tagName("a")).size();
		System.out.println("linksCount is  : "+ linksCount);
		
		System.out.println("All Links are :");
		for (int i=1; i<=linksCount; i++) {
			String links= driver.findElements(By.tagName("a")).get(i).getText();
			System.out.println(links);
			
			if(links.equalsIgnoreCase("Edit Customer")) {
				System.out.println("Link is Edit customer");
				driver.findElements(By.tagName("a")).get(i).click();
				break;
			}
			
			
		}
	*/	
		 		
	}
	
	//Explicit wait method for element click
	public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	
	{
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}

	////highlight element
	public static void highlight(WebDriver driver, WebElement ele)
	{
		
		String originalClr= ele.getCssValue("background-color");
		
		for(int i=0; i<10 ; i++)
		{
			changeColor("rgb(0, 200, 0)", driver, ele);
			changeColor(originalClr,driver, ele);
			
		}
		
		
	}
	
	////highlight element
	public static void changeColor(String clr, WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" +clr+ "'", ele);     //arguments[0]- as only 1 ele
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			
			//e.printStackTrace();
		}
		
		
	}
	
	
	public static void drawBorder(WebDriver driver, WebElement ele)
	{
		
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].style.border= '3px solid red'", ele);
		
	}
	
	public static void generateAlertForIssue(WebDriver driver, String alertMsg)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("alert('" + alertMsg + "')");
		
		
	}
	
	public static void clickOnElementByJS(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].click();", ele);
		
		
	}
	
	//REfresh browser
	
	public static void refreshBrowserWithJS(WebDriver driver)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	
	//get page title thr JS
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		String title= js.executeScript("return document.title;").toString();
		return title;
	}
	
	//return entire page text
	
	public static String getPageTextByJS(WebDriver driver)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		String pageText= js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	

	public static void scrollToElementByJS(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		
	}
	
	
}
