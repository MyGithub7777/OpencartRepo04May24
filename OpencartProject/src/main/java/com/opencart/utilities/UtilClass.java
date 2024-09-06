package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.testbase.TestBase;

public class UtilClass extends TestBase {

	public static void captureScreenshot(String filename)
	{
		try 
		{
			String path = "D:\\Workspace\\04May-EW\\Opencart04MayFramework\\screenshots\\";
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	//------------------ drop down util ------------------------------------------
	
	public static void selectOptionFromDropdownWithIndex(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public static void selectOptionFromDropdownWithValue(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectOptionFromDropdownWithVisibleText(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	//--------------------------iframe util------------------------------------
	public static void switchToIframeByIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public static void switchToIframeByIdOrName(String id)
	{
		driver.switchTo().frame(id);
	}
	
	public static void switchToIframeByElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public static void switchByToMainPageFromIframe()
	{
		driver.switchTo().defaultContent();
	}
	
	//------------------------ alert util ----------------
	
	public static void acceptAlertPopup()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlertPopup()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static String gteTextFromAlertPopup()
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	//--------------------------- Waits -------------------------
	
	public static WebElement waitForElementToClick(By locator_value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator_value));
		return element;
	}
	
	public static WebElement waitForElementToClick(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		return ele;
	}
	
	public static boolean waitForElementToSelect(By locator_value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean s = wait.until(ExpectedConditions.elementToBeSelected(locator_value));
		return s;
	}
	
	//----------------- Mouse Actions ---------------------------------
	
	public static void mouseHoverToElement(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void dragAndDropTheElement(WebElement src, WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).build().perform();
	}
}
