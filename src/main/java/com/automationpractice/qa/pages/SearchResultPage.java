package com.automationpractice.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationpractice.qa.base.TestBase;

public class SearchResultPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement PopupProceedtoCheckoutBtn;
	
	public SearchResultPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void AddingItem() {
	
		try {
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		String childWindow=null;
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		AddToCartBtn.click();
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> itr= handle.iterator();
		while(itr.hasNext()) {
			childWindow= itr.next();
			System.out.println(childWindow);
			}
		driver.switchTo().window(childWindow);
		PopupProceedtoCheckoutBtn.click();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	

}
