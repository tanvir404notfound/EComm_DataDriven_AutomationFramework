package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	
	@BeforeClass
	public void productInfoPageSetup() {
		accPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductIMGsTestData() {
		return new Object[][] {		
			{"MacBook", "MacBook Pro", 4},		
			{"iMac", "iMac", 3},
			{"Apple", "Apple Cinema 30\"", 6},
			{"Samsung", "Samsung Galaxy Tab 10.1", 7}		
		};
	}
	
	@Test(dataProvider = "getProductIMGsTestData")
	public void productIMGsCountTest(String searchKey, String productName, int imgCount) {
		searchPage = accPage.performSearch(searchKey);
		prodInfoPage = searchPage.selectProduct(productName);
		int actIMGsCount = prodInfoPage.getProductIMGCount();
		Assert.assertEquals(actIMGsCount, imgCount);
	}
	
	@Test
	public void productInfoTest() {
		searchPage = accPage.performSearch("MacBook");
		prodInfoPage = searchPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = prodInfoPage.getProductInfo();
		System.out.println(actProductInfoMap);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("productprice"), "$2,000.00");
		
		softAssert.assertAll();
	}
	
	@Test
	public void addToCartTest() {
		searchPage = accPage.performSearch("MacBook");
		prodInfoPage = searchPage.selectProduct("MacBook Pro");
		prodInfoPage.enterQuantity(1);
		prodInfoPage.addProductToCart();
		String actCartMSG = prodInfoPage.getAddToCartSuccessMSG();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actCartMSG.contains("Success"));
		softAssert.assertTrue(actCartMSG.contains("MacBook Pro"));
		
		softAssert.assertEquals(actCartMSG, "Suweweccess: You have added MacBook Pro to your shopping cart!");
		
		softAssert.assertAll();
	}
	
	

}
