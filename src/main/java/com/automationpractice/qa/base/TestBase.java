package com.automationpractice.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	
	String downloadPath=System.getProperty("user.dir")+"\\Download";
	
//	public static WebDriverWait wait = new WebDriverWait(driver,10);

	
	public TestBase() {
		try {
			log.info("Loading Property File");
			prop = new Properties();
		
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\automationpractice"
					+ "\\qa\\config\\config.properties");
			prop.load(ip);
			
		
		} catch (FileNotFoundException e) {
			log.error("Error in loading Poperty File");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Error in loading Poperty File");
			e.printStackTrace();
		}

	}

	public void initialization() {
		try {
			
			
			log.info("Validating URL");
			ValidateURL();
			log.info("Setting Preferences for Chrome");
			 HashMap<String, Object> chromePrefs = new HashMap <String, Object>();
		       chromePrefs.put("profile.default_content_settings.popups", 0);
		       chromePrefs.put("download.default_directory", downloadPath);
		       ChromeOptions options = new ChromeOptions();
		       HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		       options.setExperimentalOption("prefs", chromePrefs);
		       options.addArguments("--test-type");
		       
		  
		       DesiredCapabilities cap = DesiredCapabilities.chrome();
		       cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		       cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		       cap.setCapability(ChromeOptions.CAPABILITY, options);   
		       
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver(cap);
			log.info("Loading Browser");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(UserUrl);
			log.info("Application launched successfully..!!");
			log.info(driver.getCurrentUrl());
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
			log.error("Entered URL is Invalid");
			Assert.assertTrue(false);
			bool = false;
			}
		return bool;
	}
	
	public void FailScenario() {
		log.info("Taking Failure Screenshot");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "Failure Screenshot_" +System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}