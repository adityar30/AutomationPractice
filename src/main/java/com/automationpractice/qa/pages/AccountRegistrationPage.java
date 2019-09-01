package com.automationpractice.qa.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.qa.base.TestBase;



public class AccountRegistrationPage extends TestBase{
	
	static Logger log = Logger.getLogger(AccountRegistrationPage.class);

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
		log.info("Getting and Entering Testdata from Excel file");
		log.info("Page Title: "+driver.getTitle());
		
		log.info("Clicking on Title Radio button");
		TitleRadioBtnMr.click();
		
		log.info("Entering First Name and value is "+name);
		FirstNameTxtBox.sendKeys(name);
		
		log.info("Entering Last Name and value is "+lname);
		LastNameTxtBox.sendKeys(lname);
		
		log.info("Entering Password from Property File and value is "+prop.getProperty("Password"));
		PasswordTxtBox.sendKeys(prop.getProperty("Password"));
		
		log.info("Entering Days in dropdown and value is "+days.replace(".0", ""));
		DobDaysdrpdwn.sendKeys(days.replace(".0", ""));
		
		log.info("Entering Month in dropdown and value is "+month);
		DobMonthDrpdwn.sendKeys(month);
		
		log.info("Entering year in dropdown and value is "+year.replace(".0", ""));
		DobYearDrpddwn.sendKeys(year.replace(".0", ""));
		
		log.info("Entering Company name and value is "+comp);
		AddressCompanyTxtBox.sendKeys(comp);
		
		log.info("Entering Address and value is "+address);
		AddressTxtBox1.sendKeys(address);
		
		log.info("Entering City name and value is "+city);
		AddressCityTxtBox.sendKeys(city);
		
		log.info("Entering State name and value is "+state);
		AddressStateDrpdwn.sendKeys(state);
		
		log.info("Entering Zipcode and value is "+zipcode.replace(".0", ""));
		AddressZipTxtBox.sendKeys(zipcode.replace(".0", ""));
		
		log.info("Entering Home Phone number and value is "+phone.replace(".0", ""));
		AddressHomePhoneTxtBox.sendKeys(phone.replace(".0", ""));
		
		log.info("Entering Mobile number and value is "+mobile.replace(".0", ""));
		AddressMobilePhoneTxtBox.sendKeys(mobile.replace(".0", ""));
		
		log.info("Clearing Alias textbox");
		AddressAliasTxtBox.clear();
		
		log.info("Enter Alias Address and value is "+alias);
		AddressAliasTxtBox.sendKeys(alias);
		
		log.info("Clicking on Register button");
		RegisterBtn.click();
	
	
		}
	catch(Exception e) {
		
		log.error("Unable to Register User");
		e.printStackTrace();
	}
	
	}
	
	
	
}
