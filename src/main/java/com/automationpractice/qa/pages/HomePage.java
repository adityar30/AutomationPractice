package com.automationpractice.qa.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automationpractice.qa.base.TestBase;


public class HomePage extends TestBase {
	
	static Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(linkText="Sign in")
	WebElement LoginBtn;
	
		
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void HomePageLoginBtnClick() {
		try {
			
			log.info("Clicking on Login link");
			LoginBtn.click();
			}
		catch(Throwable e)
		{
			log.info("Unable to click on Login link");
			e.printStackTrace();
		}
	}
	
	




}
