package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.util.TestUtil;

public class OrderConfirmationPage extends TestBase{

	@FindBy(xpath="//*[@id=\"center_column\"]/p/a")
	WebElement BackToOrdersLink;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	WebElement OrderConfirmationMessageLabel;
	
	public OrderConfirmationPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void OrderConfirmation() {

		try {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		String confirmationMessage="Your order on My Store is complete.";
		Assert.assertEquals(confirmationMessage, OrderConfirmationMessageLabel.getText(),"Order Confirmed");
		new TestUtil().takeScreenshot();
			}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		}
	
	public void BackToOrders() {
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		BackToOrdersLink.click();
	}
	
}
