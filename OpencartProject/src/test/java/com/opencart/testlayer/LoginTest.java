package com.opencart.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pagelayer.Homepage;
import com.opencart.pagelayer.Loginpage;
import com.opencart.pagelayer.MyAccountpage;
import com.opencart.testbase.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void verifyLoginWithValidDetails()
	{
		String expected_result = "My Account";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		MyAccountpage myaccountpage_obj = new MyAccountpage(driver);
		logger.info("Object creation");
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		
		loginpage_obj.enterEmailAddress("davidtestuser2@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		logger.info("clicked on login button");
		
		String actual_result = myaccountpage_obj.getMyAccountText();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
	

	@Test
	public void verifyLoginWithInValidDetails()
	{
		String expected_result = "Warning: No match for E-Mail Address and/or Password.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		logger.info("Object creation");
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		
		loginpage_obj.enterEmailAddress("davidtestuser2@gmail.com");
		loginpage_obj.enterPassword("dfjhsdikgf");
		loginpage_obj.clickOnLoginButton();
		logger.info("clicked on login button");
		
		String actual_result = loginpage_obj.getErrorMessageFromLoginpage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}

}
