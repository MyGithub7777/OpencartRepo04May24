package com.opencart.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pagelayer.Homepage;
import com.opencart.pagelayer.Registerpage;
import com.opencart.testbase.TestBase;

public class RegisterTest extends TestBase {

	@Test
	public void verifyRegisterWithValidDetails()
	{
		String expected_result = "Your Account Has Been Created!";
		
		Homepage homepage_obj = new Homepage(driver);
		Registerpage registerpage_obj = new Registerpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		
		registerpage_obj.enterFirstName("david");
		registerpage_obj.enterLastName("testuser6");
		registerpage_obj.enterEmail("davidtestuser6@gmail.com");
		registerpage_obj.entertelephone("54645464");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		
		String actual_result = registerpage_obj.getSuccessfulMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
	
	@Test
	public void verifyRegisterWithAlreadyExistingEmail()
	{
		String expected_result = "Warning: E-Mail Address is already registered!";
		
		Homepage homepage_obj = new Homepage(driver);
		Registerpage registerpage_obj = new Registerpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		
		registerpage_obj.enterFirstName("david");
		registerpage_obj.enterLastName("testuser2");
		registerpage_obj.enterEmail("davidtestuser2@gmail.com");
		registerpage_obj.entertelephone("54645464");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		
		String actual_result = registerpage_obj.getErrorMessageFromRegisterPage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
}
