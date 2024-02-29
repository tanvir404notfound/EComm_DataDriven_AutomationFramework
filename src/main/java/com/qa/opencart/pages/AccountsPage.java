package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By searchBox = By.name("search");
	private By searchBTN = By.cssSelector("#search button");

		
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Accounts Page Title is: " +title);
		return title;
	}
	
	public String getAccountsPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Accounts Page Url is: " +url);
		return url;
	}
	
	public int getLogOutLinkCount() {
		int count = eleUtil.getTotalElementsCount(logoutLink);
		return count;
	}
	
	public SearchPage performSearch(String productName) {
		eleUtil.doSendKeys(searchBox, productName);
		eleUtil.doClick(searchBTN);
		return new SearchPage(driver);
	}
	

}
