package com.automationpractice.qa.base;

import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	static String UserUrl;
	static Logger log = Logger.getLogger(TestBase.class);
	public static EventFiringWebDriver eventdriver;
	public static EventHandler handler;
	String downloadPath=System.getProperty("user.dir")+"\\Download";
	
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
		       
		     LoggingPreferences logPrefs = new LoggingPreferences();
		     logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
		     logPrefs.enable(LogType.PROFILER, Level.INFO);
		     logPrefs.enable(LogType.BROWSER, Level.INFO);
		     logPrefs.enable(LogType.CLIENT, Level.INFO);
		     logPrefs.enable(LogType.DRIVER, Level.INFO);
		     logPrefs.enable(LogType.SERVER, Level.INFO);
		     cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

     
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver(cap);
			log.info("Loading and maximizing Browser");
			driver.manage().window().maximize();
			log.info("Deleting Browser cookies");
			driver.manage().deleteAllCookies();
			driver.get(UserUrl);
			log.info("Application launched successfully..!!");
			log.info("Current Application URL is: "+driver.getCurrentUrl());
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			} 
		catch (Throwable ex) {
			
			log.error("Not able to launch Application");
			ex.printStackTrace();
			}
	
	}
	
	public static boolean ValidateURL() {
		
		boolean bool=true; 
		try {
		
		
		
		UserUrl = prop.getProperty("url").trim().toLowerCase();
		
		
		if( UserUrl!= null) {
			new URL(UserUrl).toURI();
			
			log.info("Entered URL is Valid");
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
			
			log.error("Not able to take error Screenshot");
			e.printStackTrace();
		}
		
	}
	
	public void extractChromelogs() {
		log.info("In Extracting Browser logs method");
		LogEntries logentries=driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry: logentries) {
			
			log.info(new Date(entry.getTimestamp() + " " + entry.getLevel() + " " + entry.getMessage()));
		}
		
		
	}
}