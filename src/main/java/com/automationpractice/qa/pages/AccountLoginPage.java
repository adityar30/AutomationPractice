package com.automationpractice.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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
	
	static Logger log = Logger.getLogger(AccountLoginPage.class);
		
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
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li")
	WebElement ValidationForLoginMessage;
	
	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void HomePageCreateAccount() {
		try {
		log.info("Home Page - getting Email address from Property file");
		EmailAddressTxtBox.sendKeys(prop.getProperty("Email"));
		log.info("Clicking on Create Account link");
		CreateAccountBtn.click();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);	
		}catch(Exception e) {
			
			log.error("Unable to Create Account");
			e.printStackTrace();
		}
		}
	public void LoginAfterRegistration() {
		try {
			
			log.info("Page Title: "+driver.getTitle());
			LoginEmailAddressTxtBox.sendKeys(prop.getProperty("Email"));
			log.info("Loading Email from Property file");
			log.info("Value of Email from Property file " +prop.getProperty("Email"));
			LoginPasswordTxtBox.sendKeys(prop.getProperty("Password"));
			log.info("Loading Password from Property file");
			log.info("Value of Email from Property file " +prop.getProperty("Password"));
			log.info("Taking screenshot after entering Email and Password");
			new TestUtil().takeScreenshot();
			log.info("Clicking on SignIn button");
			SignInBtn.click();
			log.info("Taking screenshot after successful Sign-in");
			new TestUtil().takeScreenshot();
			} catch (IOException e) {
			
			log.info("Unable to login After Registration");
			e.printStackTrace();
		}
	}

	public void LoginFail() {
		
		try {
			log.info("Entering Invalid Email address");
			EmailAddressTxtBox.sendKeys(prop.getProperty("WrongEmail"));
			log.info("Clicking on Create Account button");
			CreateAccountBtn.click();
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);	
			log.info("Assertion to fail the Testcase");
			soft.assertEquals(prop.getProperty("WrongEmail"), ValidationForLoginMessage.getText(),ValidationForLoginMessage.getText());
			
			} 
		catch (Throwable e) {
			
			log.error("Invalid Email from Log");
			e.printStackTrace();
		}
		soft.assertAll();
	}

}
