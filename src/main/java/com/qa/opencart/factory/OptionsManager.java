package com.qa.opencart.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
//		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
//			co.setBrowserVersion(prop.getProperty("browserversion"));
//			co.setCapability("browserVersion", prop.getProperty("browserversion"));
//			Map<String, Object> selenoidOptions = new HashMap<>();
//			selenoidOptions.put("screenResolution", "1280x1024x24");
//			selenoidOptions.put("enableVNC", true);
//			selenoidOptions.put("name", prop.getProperty("testname"));
//			co.setCapability("selenoid:options", selenoidOptions);
//		}
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("------Running Chrome in Headless------");
			co.addArguments("--headless");	
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito")))	co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getFireFoxOptions() {
		fo = new FirefoxOptions();
		
//		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
//			//fo.setBrowserVersion(prop.getProperty("browserversion"));
//			fo.setCapability("browserVersion", prop.getProperty("browserversion"));
//			Map<String, Object> selenoidOptions = new HashMap<>();
//			selenoidOptions.put("screenResolution", "1280x1024x24");
//			selenoidOptions.put("enableVNC", true);
//			selenoidOptions.put("name", prop.getProperty("testname"));
//			fo.setCapability("selenoid:options", selenoidOptions);
//		}
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");	
		if(Boolean.parseBoolean(prop.getProperty("incognito")))	fo.addArguments("--incognito");
		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		eo.addArguments("--guest");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");	
		if(Boolean.parseBoolean(prop.getProperty("incognito")))	eo.addArguments("--incognito");
		return eo;
	}
}
