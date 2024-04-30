package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	private By fNameBox = By.id("input-firstname");
	private By lNameBox = By.id("input-lastname");
	private By emailBox = By.id("input-email");
	private By telephoneBox = By.id("input-telephone");
	private By passwordBox = By.id("input-password");
	private By confirmPWDBox = By.id("input-confirm");
	private By newsletterRadioBTNYes = By.xpath("//input[@name='newsletter' and @value='1']");
	private By newsletterRadioBTNNo = By.xpath("//input[@name='newsletter' and @value='0']");
	
	private By privacyPolicyCheckBox = By.xpath("//input[@name='agree']");
	private By continueBTN = By.xpath("//input[@value='Continue']");
	private By registerSuccessMSG = By.cssSelector("div#content h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	public boolean registerUser(String firstName, String lastName, String email,
			String telephone, String password, String subscribe) {
		
		eleUtil.waitForElementVisible(fNameBox, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(lNameBox, lastName);
		eleUtil.doSendKeys(emailBox, email);
		eleUtil.doSendKeys(telephoneBox, telephone);
		eleUtil.doSendKeys(passwordBox, password);
		eleUtil.doSendKeys(confirmPWDBox, password);
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(newsletterRadioBTNYes);
		}
		else if(subscribe.equalsIgnoreCase("no")) {
			eleUtil.doClick(newsletterRadioBTNNo);
		}
		
		jsUtil.scrollPageDown();
		eleUtil.doActionsCick(privacyPolicyCheckBox);
		eleUtil.doClick(continueBTN);
		
		String successMSG = eleUtil.waitForElementVisible(registerSuccessMSG, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		
		if(successMSG.contains("Your Account Has Been Created")) {		
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);		
			return true;
		}
		return false;
		
	} 
	
	

	

}
