package com.automationpractice.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountLoginPage;
import com.automationpractice.qa.pages.AccountRegistrationPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.ManageAddressPage;
import com.automationpractice.qa.pages.OrderConfirmationPage;
import com.automationpractice.qa.pages.OrderHistoryPage;
import com.automationpractice.qa.pages.OrderSummaryPage;
import com.automationpractice.qa.pages.PaymentPage;
import com.automationpractice.qa.pages.SearchPage;
import com.automationpractice.qa.pages.SearchResultPage;
import com.automationpractice.qa.pages.ShippingPage;
import com.automationpractice.qa.pages.ShoppingCartPage;
import com.automationpractice.qa.pages.UserAccountPage;
import com.automationpractice.qa.util.TestUtil;

@Listeners(com.automationpractice.qa.util.WebEventListener.class)
public class Testcases extends TestBase{
	
	HomePage home;
	AccountLoginPage accountlogin;
	AccountRegistrationPage accountreg;
	ManageAddressPage manageaddress;
	OrderConfirmationPage orderconfirmation;
	OrderHistoryPage orderhistory;
	OrderSummaryPage ordersummary;
	PaymentPage payment;
	SearchPage search;
	SearchResultPage searchresult;
	ShippingPage shipping;
	ShoppingCartPage shopping;
	UserAccountPage user;
	static Logger log = Logger.getLogger(Testcases.class);


	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("SheetName"));
		return data;
	} 
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void AutomationPractice_TC01 (String name, String lname,String days, String month, String year, String comp, 
			String address, String city, String state, String zipcode, String phone, String mobile, String alias)  {
		
		log.info("***Executing Test Cases***");
		log.info("Executing Test Case - AutomationPractice_TC01");
		initialization();
		home=new HomePage();
		home.HomePageLoginBtnClick();
		accountlogin=new AccountLoginPage();
		accountlogin.HomePageCreateAccount();
		accountreg=new AccountRegistrationPage();
		accountreg.UserDetailsAccountCreation(name, lname, days,  month,  year,  comp, 
				 address,  city,  state,  zipcode,  phone,  mobile,  alias);
		user=new UserAccountPage();
		user.Logout();
		accountlogin.LoginAfterRegistration();
		log.info("AutomationPractice_TC01 executed successfully");
		}
	
	@Test(priority=2, dependsOnMethods= {"AutomationPractice_TC01"})
	public void AutomationPractice_TC02() {
		
		log.info("Executing Test Case - AutomationPractice_TC02");
		user.SearchItem();
		search=new SearchPage();
		search.VerifySearchCountAndResult();
		log.info("AutomationPractice_TC02 executed successfully");
	}
	
	@Test(priority=3, dependsOnMethods= {"AutomationPractice_TC02"})
	public void AutomationPractice_TC03() {
		log.info("Executing Test Case - AutomationPractice_TC03");
		search.MoreResultView();
		searchresult=new SearchResultPage();
		searchresult.AddingItem();
		shopping=new ShoppingCartPage();
		shopping.ProceedTocheckout();
		manageaddress=new ManageAddressPage();
		manageaddress.ProceedTocheckout();
		shipping=new ShippingPage();
		shipping.AgreeTerms();
		shipping.ProceedTocheckout();
		payment=new PaymentPage();
		payment.PaymentMethod();
		ordersummary=new OrderSummaryPage();
		ordersummary.ConfirmingOrder();
		orderconfirmation=new OrderConfirmationPage();
		orderconfirmation.BackToOrders();
		log.info("AutomationPractice_TC03 executed successfully");
	}
	
	@Test(priority=4, dependsOnMethods= {"AutomationPractice_TC03"})
	public void AutomationPractice_TC04() {
		log.info("Executing Test Case - AutomationPractice_TC04");
		orderhistory=new OrderHistoryPage();
		orderhistory.Download();
		orderhistory.VerifyDownload();
		orderhistory.OrderHistoryLogout();
		log.info("AutomationPractice_TC04 executed successfully");
	}
	
	@Test(priority=5, dependsOnMethods= {"AutomationPractice_TC01"})
	public void AutomationPractice_TC05() {
		log.info("Executing Test Case - AutomationPractice_TC05");
		accountlogin.LoginFail();
		log.info("AutomationPractice_TC05 executed successfully");
		}
	
	@AfterSuite
	public void tearDown() {
		
		log.info("Closing the Browser");
		driver.close();
		log.info("***Test Case execution completed***");
		
	}
}
