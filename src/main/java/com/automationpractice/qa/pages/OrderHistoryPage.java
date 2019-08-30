package com.automationpractice.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class OrderHistoryPage extends TestBase{

	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr/td[6]/a")
	WebElement InvoicePDFLink;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement Logout;
	
	public OrderHistoryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void Download() {
		
		try {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		InvoicePDFLink.click();
		ArrayList<String> tab= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	    driver.close();
	    driver.switchTo().window(tab.get(0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void VerifyDownload() {
		try {
			
		
		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePref = new HashMap<String, Object>();

		chromePref.put("download.default_directory", "\\AutomationPractice\\Download");

		options.setExperimentalOption("prefs", chromePref);
		
		//System.out.println("File Downloaded Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderHistoryLogout() {
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Logout.click();
		
	}
}
