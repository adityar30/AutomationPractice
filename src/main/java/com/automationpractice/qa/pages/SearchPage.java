package com.automationpractice.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.automationpractice.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	static Logger log = Logger.getLogger(SearchPage.class);
				
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[*]/div/div[2]/h5/a") 
	List<WebElement> SearchResults;
			
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div")
	WebElement SearchProduct;
			
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public void VerifySearchCountAndResult() {
		try {
		int Result=SearchResults.size();
		log.info("No of Results for entered Search "+Result);
		
		log.info("Comparing Result with Search String");
		Iterator<WebElement> itr=SearchResults.iterator();
		while(itr.hasNext()) {
			
			String temp=itr.next().getText();
			System.out.println(temp);
			String temp2=prop.getProperty("SearchString");
			
			if(temp.toLowerCase().contains(temp2.toLowerCase())) {
				
				log.debug("Search String avaialble in Search Result: " +temp);
			}
			else
			{
			
				log.fatal("Search String not avaialble in Search Result:" +temp);
				System.out.println("Search String not avaialble in Search Result: " +temp);
				
				
			}
			
		}}catch(Exception e) {
			log.error("Search Results not available");
			e.printStackTrace();
		}
		
	}
	
	public void MoreResultView() {
		
		try {
			
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Clicking on Product");
		SearchProduct.click();}
		catch(Exception e) {
			log.error("Unable to Search for item");
			e.printStackTrace();
		}
	}

}
