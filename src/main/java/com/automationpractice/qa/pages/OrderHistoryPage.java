package com.automationpractice.qa.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class OrderHistoryPage extends TestBase{
	
	static Logger log = Logger.getLogger(OrderHistoryPage.class);

	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr/td[6]/a")
	WebElement InvoicePDFLink;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement Logout;
	
	String downloadPath=System.getProperty("user.dir")+"\\Download";
	
	public OrderHistoryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void Download() {
		
		try {
		log.info("Page Title: "+driver.getTitle());
		log.info("Clicking on Invoice link");
		InvoicePDFLink.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Getting List of Tabs");
		ArrayList<String> tab= new ArrayList<String> (driver.getWindowHandles());
		log.info("Switching to Child Tab");
		driver.switchTo().window(tab.get(1));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Closing Child Tab");
	    driver.close();
	    log.info("Switching back to Parent Tab");
	    driver.switchTo().window(tab.get(0));
		}
		catch(Exception e) {
			
			log.error("Error in Switching Tabs");
			e.printStackTrace();
		}
		
	}

	public void VerifyDownload() {
		try {
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			File file = new File(downloadPath);
			if (file.exists()) {
			    
			log.info("Invoice File Downloaded and available in Dowload Folder");    
			}else {
				log.fatal("Invoice File not available");  
				
			}
		
		
		}catch(Exception e) {
			log.error("Error in downloading Invoice File");  
			
			e.printStackTrace();
		}
	}
	
	public void OrderHistoryLogout() {
		try {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Logging out from the application");
		Logout.click();
		}
		catch(Exception e) {
			
			log.error("Not able to logout");
		}
		
	}
}
