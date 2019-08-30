package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.util.TestUtil;

public class AccountRegistrationPage extends TestBase{

	@FindBy(id="id_gender1")
	WebElement TitleRadioBtnMr;	
		
	@FindBy(id="customer_firstname")
	WebElement FirstNameTxtBox;	
	
	@FindBy(id="customer_lastname")
	WebElement LastNameTxtBox;	
	
	@FindBy(id="email")
	WebElement EmailTxtBox;	
	
	@FindBy(id="passwd")
	WebElement PasswordTxtBox;
	
	@FindBy(id="days")
	WebElement DobDaysdrpdwn;
	
	@FindBy(id="months")
	WebElement DobMonthDrpdwn;
	
	@FindBy(id="years")
	WebElement DobYearDrpddwn;
	
	@FindBy(id="firstname")
	WebElement AddressFirstNameTxtBox;	
	
	@FindBy(id="lastname")
	WebElement AddressLastNameTxtBox;	
	
	@FindBy(id="company")
	WebElement AddressCompanyTxtBox;	
	
	@FindBy(id="address1")
	WebElement AddressTxtBox1;
	
	@FindBy(id="city")
	WebElement AddressCityTxtBox;
	
	@FindBy(id="id_state")
	WebElement AddressStateDrpdwn;
	
	@FindBy(id="postcode")
	WebElement AddressZipTxtBox;
	
	@FindBy(id="uniform-id_country")
	WebElement AddressCountryDrpdwn;
	
	@FindBy(id="phone")
	WebElement AddressHomePhoneTxtBox;
	
	@FindBy(id="phone_mobile")
	WebElement AddressMobilePhoneTxtBox;
	
	@FindBy(id="alias")
	WebElement AddressAliasTxtBox;
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]")
	WebElement RegisterBtn;

	public AccountRegistrationPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void UserDetailsAccountCreation(String name, String lname,String days, String month, String year, String comp, 
			String address, String city, String state, String zipcode, String phone, String mobile, String alias) 
	{
		
		
	try {	
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		TitleRadioBtnMr.click();
		FirstNameTxtBox.sendKeys(name);
		LastNameTxtBox.sendKeys(lname);
		String email=EmailTxtBox.getText();
		PasswordTxtBox.sendKeys(prop.getProperty("Password"));
		DobDaysdrpdwn.sendKeys(days.replace(".0", ""));
		DobMonthDrpdwn.sendKeys(month);
		DobYearDrpddwn.sendKeys(year.replace(".0", ""));
		String firstname=AddressFirstNameTxtBox.getText();
		String lastname=AddressLastNameTxtBox.getText();
		AddressCompanyTxtBox.sendKeys(comp);
		AddressTxtBox1.sendKeys(address);
		AddressCityTxtBox.sendKeys(city);
		AddressStateDrpdwn.sendKeys(state);
		AddressZipTxtBox.sendKeys(zipcode.replace(".0", ""));
		AddressHomePhoneTxtBox.sendKeys(phone.replace(".0", ""));
		AddressMobilePhoneTxtBox.sendKeys(mobile.replace(".0", ""));
		AddressAliasTxtBox.clear();
		AddressAliasTxtBox.sendKeys(alias);
		RegisterBtn.click();
	
	
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
	
	
}
