package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void accountsPageTitleTest() {
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void accountsPageURLTest() {
		Assert.assertEquals(accPage.getAccountsPageURL(), AppConstants.ACCOUNTS_PAGE_URL_VALUE);
	}
	
	@Test
	public void getLogOutLinkCount() {
		Assert.assertEquals(accPage.getLogOutLinkCount(), AppConstants.ACCOUNTS_PAGE_LOGOUT_COUNT);
	}
	
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			
			{"MacBook"},
			{"iMac"},
			{"Apple"},
			{"Samsung"}
			
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchProductCountTest(String productName) {
		searchPage = accPage.performSearch(productName);
		//Assert.assertEquals(searchPage.getSearchProductsCount(), 3);
		Assert.assertTrue(searchPage.getSearchProductsCount()>0);
	}
	
	
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			
			{"MacBook", "MacBook Pro"},
			{"MacBook", "MacBook Air"},
			
			{"iMac", "iMac"},
			{"Apple", "Apple Cinema 30\""},
			{"Samsung", "Samsung Galaxy Tab 10.1"}
			
		};
	}
	
	@Test(dataProvider = "getProductTestData")
	public void searchProductTest(String searchKey, String productName) {
		searchPage = accPage.performSearch(searchKey);
		prodInfoPage = searchPage.selectProduct(productName);
		String actProductHeader = prodInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeader, productName);
	}
	
}
