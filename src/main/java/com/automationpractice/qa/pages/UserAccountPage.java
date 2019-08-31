package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationpractice.qa.base.TestBase;

public class UserAccountPage extends TestBase{
	
	static Logger log = Logger.getLogger(UserAccountPage.class);
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement LogoutBtn;
	
	@FindBy(id="search_query_top")
	WebElement SearchTxtBox;
	
	@FindBy(name="submit_search")
	WebElement SearchBtn;
	
	public UserAccountPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void Logout() {
		try {
		log.info("Page Title:"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Clicking on Logout button");
		LogoutBtn.click();
		}
		catch(Exception e) {
			log.error("Not able to Logout");
			e.printStackTrace();
		}
	}

	public void SearchItem() {
		try {
			log.info("Getting Search string from Property");
		SearchTxtBox.sendKeys(prop.getProperty("SearchString"));
		log.info("Clicking on Search button");
		SearchBtn.click();
		}catch(Exception e) {
			
			log.error("Unable to Search item");
			e.printStackTrace();
		}
	}
}
