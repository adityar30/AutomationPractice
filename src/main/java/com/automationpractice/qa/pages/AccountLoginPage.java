package com.automationpractice.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.util.TestUtil;

public class AccountLoginPage extends TestBase{
	
	SoftAssert soft=new SoftAssert();
		
	@FindBy(id="email_create")
	WebElement EmailAddressTxtBox;	
	
	@FindBy(id="SubmitCreate")
	WebElement CreateAccountBtn;	
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement LoginEmailAddressTxtBox;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement LoginPasswordTxtBox;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement SignInBtn;
	
	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void HomePageCreateAccount() {
		try {
		
		EmailAddressTxtBox.sendKeys(prop.getProperty("Email"));
		CreateAccountBtn.click();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);	
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		}
	public void LoginAfterRegistration() {
		try {
			String title=driver.getTitle();
			System.out.println("Page title is: "+title);
			LoginEmailAddressTxtBox.sendKeys(prop.getProperty("Email"));
			LoginPasswordTxtBox.sendKeys(prop.getProperty("Password"));
			new TestUtil().takeScreenshot();
			SignInBtn.click();
			new TestUtil().takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LoginFail() {
		
		try {
			EmailAddressTxtBox.sendKeys(prop.getProperty("WrongEmail"));
			CreateAccountBtn.click();
		
			soft.assertEquals(true, false,"Invalid Email");
			
			} 
		catch (Throwable e) {
			
			e.printStackTrace();
		}
		soft.assertAll();
	}

}
