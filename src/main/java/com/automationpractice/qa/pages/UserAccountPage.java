package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationpractice.qa.base.TestBase;

public class UserAccountPage extends TestBase{
	
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
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		LogoutBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchItem() {
		try {
		SearchTxtBox.sendKeys(prop.getProperty("SearchString"));
		SearchBtn.click();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
