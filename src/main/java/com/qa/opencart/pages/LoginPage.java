package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By loginEmailBox = By.id("input-email");
	private By loginPWBox = By.id("input-password");
	private By loginBTN = By.xpath("//input[@value='Login']");
	private By registerLink = By.linkText("Register");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Login Page Title is: " +title);
		return title;
	}
	
	public String getLoginPageURL() {
		//eleUtil.waitForURLIsAndFetch(5, getLoginPageURL());
		String url = driver.getCurrentUrl();
		System.out.println("Login Page Url is: " +url);
		return url;
	}
	
	public AccountsPage login(String un, String pw) {
		eleUtil.waitForElementVisible(loginEmailBox, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(loginPWBox, pw);
		eleUtil.doClick(loginBTN);
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	
	
}
