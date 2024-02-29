package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test(priority=2)
	public void loginPageURLTest() {
		Assert.assertEquals(loginPage.getLoginPageURL(), AppConstants.LOGIN_PAGE_URL_VALUE);
	}
	
	@Test(priority=3)
	public void loginTest() {
		accPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountsPageURL(), AppConstants.ACCOUNTS_PAGE_URL_VALUE);
	}
	
	//3
	//00:59;00
	
}
