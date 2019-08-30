package com.automationpractice.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	static String UserUrl;
	static Logger log = Logger.getLogger(TestBase.class);
	
//	public static WebDriverWait wait = new WebDriverWait(driver,10);

	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\automationpractice"
					+ "\\qa\\config\\config.properties");
			prop.load(ip);
			
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void initialization() {
		try {
			log.info("Validating URL");
			ValidateURL();
			// String Url="http://automationpractice.com/index.php";
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Loading Browser");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(UserUrl);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			} 
		catch (Throwable ex) {
			
			System.out.println("Invalid URL");
		}
	
	}
	
	public static boolean ValidateURL() {
		
		boolean bool=true; 
		try {
			
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Website URL");
		UserUrl = sc.nextLine().trim().toLowerCase();
		if( UserUrl!= null) {
			new URL(UserUrl).toURI();
			
			log.info("Valid URL");
			bool=true;
			
		}
		}catch(Exception e)
		{
			log.info("Invalid URL");
			Assert.assertTrue(false);
			bool = false;
			}
		return bool;
	}
	
	public void FailScenario() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "Fail Screenshot_" +System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}