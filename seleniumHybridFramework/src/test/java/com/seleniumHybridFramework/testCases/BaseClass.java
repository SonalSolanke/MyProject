package com.seleniumHybridFramework.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.seleniumHybridFramework.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	
	static ReadConfig rc= new ReadConfig();
	public String baseURL = rc.getApplicationURL();
	public String userName= rc.getUsername();
	public String password = rc.getPassword();
	
	@Parameters ("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",rc.getChromeBrowserPath());
			driver= new ChromeDriver();	
		}
		
		else if(br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromeBrowserPath());  //set diff methods for IE and firefox
			driver= new InternetExplorerDriver();
		}
		
		else if(br.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromeBrowserPath());
			driver= new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	/*
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	*/
	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source =ts.getScreenshotAs(OutputType.FILE);
		File Target= new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		
		FileUtils.copyFile(Source, Target);
		System.out.println("Screenshot Captured");
	}
	
	//to return random string. Inbuilt class sin java- RandomStringUtils
		public String randonString(int count) {
			return RandomStringUtils.randomAlphabetic(count);
		}
		
		public String randomNumber(int count) {
			return RandomStringUtils.randomNumeric(count);
		}
		
		
		public boolean isAlertPresent() {
			try {
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e){
				return false;
			}
				
				
			}
	
}

