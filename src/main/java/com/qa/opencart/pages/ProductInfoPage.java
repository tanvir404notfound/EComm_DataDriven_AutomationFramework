package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productHeader = By.tagName("h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private By productQtyTextBox = By.id("input-quantity");
	private By addToCartBTN = By.id("button-cart");
	private By addToCartSuccessMSG = By.cssSelector("div.alert.alert-success");
	
	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);		
	}

	public String getProductHeaderValue() {
		String productHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println("Product Header is: "+productHeaderValue);
		return productHeaderValue;
	}
	
	public int getProductIMGCount() {
		int imgCount = eleUtil.waitForElementsVisible(productImages, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("Number of images: "+imgCount);
		return imgCount;
	}
	
	public void enterQuantity(int quantity) {
		System.out.println("Product Quantity is: "+quantity);
		eleUtil.doSendKeys(productQtyTextBox, String.valueOf(quantity));
	}
	
	public void addProductToCart() {
		eleUtil.doClick(addToCartBTN);
		eleUtil.waitForElementVisible(addToCartSuccessMSG, AppConstants.DEFAULT_SHORT_TIME_OUT);
	}
	
	public String getAddToCartSuccessMSG() {
		String successMSG = eleUtil.waitForElementVisible(addToCartSuccessMSG, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Cart success msg: "+successMSG.substring(0, successMSG.length()-1).replace("\n", ""));	
		return successMSG.substring(0, successMSG.length()-1).replace("\n", "");
	}
	
	public Map<String, String> getProductInfo() {
		
		//productInfoMap = new HashMap<String, String>();
		productInfoMap = new LinkedHashMap<String, String>();
		
		//header
		productInfoMap.put("productname", getProductHeaderValue());
		getProductMetaData();
		getProductPriceData();	
		return productInfoMap;
	}
	
	private void getProductMetaData() {
		//Brand: Apple
		//Product Code: Product 18
		//Reward Points: 800
		//Availability: In Stock
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for(WebElement e : metaList) {
			String metaText = e.getText();
			String metaInfo[] = metaText.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);					
			
		}	
	}
	
	private void getProductPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String exTaxVal = exTax.split(":")[1].trim();
		
		productInfoMap.put("productprice", price);
		productInfoMap.put("exTax", exTaxVal);
	}
	
	
}
