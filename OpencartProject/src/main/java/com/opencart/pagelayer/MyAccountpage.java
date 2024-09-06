package com.opencart.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {

	public MyAccountpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//----------- Obj repo --------------------
	@FindBy(xpath="//a[contains(text(),'Address Book')]")
	private WebElement address_book_link;
	
	@FindBy(xpath="//div/h2[1]")
	private WebElement my_account_text;
	
	//-------- action method ---------------
	
	public void clickOnAddressBookLink()
	{
		address_book_link.click();
	}
	
	public String getMyAccountText()
	{
		String text = my_account_text.getText();
		return text;
	}
}
