package com.automationpractice.qa.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automationpractice.qa.base.TestBase;


public class HomePage extends TestBase {
	
	
	@FindBy(linkText="Sign in")
	WebElement LoginBtn;
	

	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void HomePageLoginBtnClick() {
		try {
			
			String title=driver.getTitle();
			System.out.println("Page title is: "+title);
			LoginBtn.click();
			}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	




}
