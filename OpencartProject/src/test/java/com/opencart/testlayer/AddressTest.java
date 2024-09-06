package com.opencart.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pagelayer.AddressBookpage;
import com.opencart.pagelayer.Homepage;
import com.opencart.pagelayer.Loginpage;
import com.opencart.pagelayer.MyAccountpage;
import com.opencart.testbase.TestBase;

public class AddressTest extends TestBase {

	@Test
	public void verifyAddingNewAddress()
	{
		String expected_result = "Your address has been successfully added";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		MyAccountpage myaccountpage_obj = new MyAccountpage(driver);
		AddressBookpage addressbookpage_obj = new AddressBookpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		
		loginpage_obj.enterEmailAddress("davidtestuser2@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		myaccountpage_obj.clickOnAddressBookLink();
		addressbookpage_obj.clickOnNewAddressButton();
		
		addressbookpage_obj.enterFirstName("david");
		addressbookpage_obj.enterLastname("testuser2");
		addressbookpage_obj.enterCompany("Wipro");
		addressbookpage_obj.enterAddress1("COEP");
		addressbookpage_obj.enterAddress2("Shivaji Nagar");
		addressbookpage_obj.enterCity("Pune");
		addressbookpage_obj.enterPostcode("411011");
		addressbookpage_obj.selectOptionFromCountryDropdown("India");
		addressbookpage_obj.selectOptionFromRegionDropdown("Maharashtra");
		addressbookpage_obj.clickOnContinueButton();
		
		String actual_result = addressbookpage_obj.getStatusMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
}
