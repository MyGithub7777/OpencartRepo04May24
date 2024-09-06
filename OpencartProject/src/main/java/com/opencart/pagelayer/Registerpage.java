package com.opencart.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.utilities.UtilClass;

public class Registerpage {

	private WebDriver driver;
	public Registerpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//----------- Obj repo --------------------
	private By firstname_txtbox = By.xpath("//input[@id='input-firstname']");
	private By lastname_txtbox = By.xpath("//input[@id='input-lastname']");
	private By email_txtbox = By.xpath("//input[@id='input-email']");
	private By telephone_txtbox = By.xpath("//input[@id='input-telephone']");
	private By password_txtbox = By.xpath("//input[@id='input-password']");
	private By confirm_password_txtbox = By.xpath("//input[@id='input-confirm']");
	private By privacy_policy_checkbox = By.xpath("//input[@name='agree']");
	private By continue_btn = By.xpath("//input[@value='Continue']");
	
	private By success_msg = By.xpath("//div/h1");
	private By error_msg = By.xpath("//div[contains(@class,'alert-danger')]");		
	
	//--------- Action methods ----------------

	public void enterFirstName(String firstname)
	{
		driver.findElement(firstname_txtbox).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		driver.findElement(lastname_txtbox).sendKeys(lastname);
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(email_txtbox).sendKeys(email);
	}
	
	public void entertelephone(String telephone)
	{
		driver.findElement(telephone_txtbox).sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(password_txtbox).sendKeys(password);
	}
	
	public void enterConfirmPassword(String cpassword)
	{
		driver.findElement(confirm_password_txtbox).sendKeys(cpassword);
	}
	
	public void clickOnPrivacyPolicyCheckbox()
	{
		WebElement checkbox = driver.findElement(privacy_policy_checkbox);
		checkbox.click();
		
//		boolean flag = UtilClass.waitForElementToSelect(privacy_policy_checkbox);  // select - true deselect - false
//		
//		if(!flag)
//		{
//			driver.findElement(privacy_policy_checkbox).click();
//		}
		
	}
	
	public void clickOnContinueButton()
	{
//		driver.findElement(continue_btn).click();
		WebElement element = UtilClass.waitForElementToClick(continue_btn);
		element.click();
	}
	
	public String getSuccessfulMessage()
	{
		String msg = driver.findElement(success_msg).getText();
		return msg;
	}
	
	public String getErrorMessageFromRegisterPage()
	{
		String msg = driver.findElement(error_msg).getText();
		return msg;
	}
}
