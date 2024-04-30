package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class CartPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By useCouponCodeCollapsableBTN = By.xpath("//a[text()[contains(.,'Use Coupon Code')]]");
	private By couponCodeTextbox = By.id("input-coupon");
	private By estimateShipAndTaxesCollapsableBTN = By.xpath("//a[text()[contains(.,'Estimate Shipping & Taxes')]]");
	private By destCountryDD = By.id("input-country");
	private By destRegionStateDD = By.id("input-zone");
	private By destPostCodeTextBox = By.id("input-postcode");
	private By getQuotesBTN = By.id("button-quote");
	private By shippingMethodRadioBTN = By.name("shipping_method");
	private By applyShippingBTN = By.id("button-shipping");
	private By useGiftCertificateCollapsableBTN = By.xpath("//a[text()[contains(.,'Use Gift Certificate')]]");
	private By giftCertificateTextBox = By.id("input-voucher");
	private By checkOutBTN = By.xpath("//a[text()[contains(.,'Checkout')]]");
	
	private By billingFName = By.id("input-payment-firstname");
	private By billingLName = By.id("input-payment-lastname");
	private By billingAddress1 = By.id("input-payment-address-1");
	private By billingCity = By.id("input-payment-city");
	private By billingPostCode = By.id("input-payment-postcode");
	private By billingCountry = By.id("input-payment-country");
	private By billingRegionState = By.id("input-payment-zone");
	private By billingDetailsContinueBTN = By.id("button-payment-address");
	
	private By deliveryDetailsContinueBTN = By.id("button-shipping-address");
	
	private By deliveryMethodContinueBTN = By.id("button-shipping-method");
	
	private By paymentMethodTAndCCheckbox = By.name("agree");
	private By paymentMethodContinueBTN = By.id("button-payment-method");
	
	private By confirmOrderBTN = By.id("button-confirm");
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public void fillOutDeliveryCostEstimation(String cc, String couponCode, String country, String regionOrState, String postCode, String gc, String giftCertificate) {
		if(cc=="y") {
			eleUtil.waitForElementVisible(useCouponCodeCollapsableBTN, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
			eleUtil.waitForElementVisible(couponCodeTextbox, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(couponCode);
		}
			
		eleUtil.waitForElementVisible(estimateShipAndTaxesCollapsableBTN, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		eleUtil.doSelectDropDownByVisibleText(destCountryDD, country);
		eleUtil.doSelectDropDownByVisibleText(destRegionStateDD, regionOrState);
		eleUtil.doSendKeys(destPostCodeTextBox, postCode);
		eleUtil.doClick(getQuotesBTN);
		eleUtil.waitForElementVisible(shippingMethodRadioBTN, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		eleUtil.doClick(applyShippingBTN);
			
		if(cc=="y") {
			eleUtil.waitForElementVisible(useGiftCertificateCollapsableBTN, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
			eleUtil.waitForElementVisible(giftCertificateTextBox, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(giftCertificate);
		}
		
		eleUtil.doClick(checkOutBTN);
		eleUtil.waitForElementVisible(applyShippingBTN, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
	}
	
	
	
}
