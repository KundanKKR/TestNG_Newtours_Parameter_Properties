package com.qa.testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Newtours_001 extends TestBase
{
	@Test(priority=0,invocationCount=2)
	public void validateTitle()
	{
		String actTitle=driver.getTitle();
		String expTitle=prop.getProperty("expTitle");
		Assert.assertEquals(actTitle, expTitle,"actual and expected don't match");
		Reporter.log("actual title is "+actTitle,true);
		Reporter.log("expected title is "+expTitle,true);
	}
	@Test(priority=1)
	public void isTitleInUpperCase()
	{
		String title=driver.getTitle();
		String UpperTitle=title.toUpperCase();
		Assert.assertEquals(title, UpperTitle,"Title is not in upper case");
	}
	@Test(priority=3)
	public void UPTextbox()
	{
		boolean IsUserNameExist=newtoursOR.getUserName().isDisplayed();
		boolean IsPasswordExist=newtoursOR.getPassword().isDisplayed();
	/*	Assert.assertTrue(IsUserNameExist,"user name txt box is not present");
		Assert.assertTrue(IsPasswordExist,"password txt box is not present");*/
		Assert.assertEquals(IsUserNameExist, true,"user name txt box is not present");
		Assert.assertEquals(IsPasswordExist, true,"password txt box is not present");
	}
	@Test(priority=4)
	public void isSigninBtnEnabled()
	{
		boolean enabled=newtoursOR.getSubmitBtn().isEnabled();
		Assert.assertTrue(enabled,"sign in button is not enabled by default");
	}
	
	@Test(priority=4)
	public void login()
	{
		newtoursOR.getUserName().sendKeys(prop.getProperty("userName"));
		newtoursOR.getPassword().sendKeys(prop.getProperty("password"));
		newtoursOR.getSubmitBtn().click();
		String title=driver.getTitle();
		String loginTitle=prop.getProperty("loginTitle");
		Assert.assertEquals(title, loginTitle);
	}
	@Test(priority=5)
	public void flight()
	{
		newtoursOR.getFlight().click();
		String title=driver.getTitle();
		String flightTitle=prop.getProperty("flightTitle");
		Assert.assertEquals(title, flightTitle);
	}
	@Test(priority=6)
	public void isRoundTripSelected()
	{
		boolean roundTripSelected=newtoursOR.getRoundTrip().isSelected();
		Assert.assertTrue(roundTripSelected,"Round trip is not selected by default");
	}
	@Test(priority=7)
	public void fillAllDetails() throws InterruptedException
	{
		Thread.sleep(2000);
		Select passenger=new Select(newtoursOR.getPassenger());
		
		/*passenger.selectByVisibleText(prop.getProperty("noOfPassenger"));*///2 passenger
		int index=Integer.parseInt(prop.getProperty("passengerIndex"));
		passenger.selectByIndex(index);//2 passenger
		
		Thread.sleep(2000);
		Select from=new Select(newtoursOR.getFrom());
		from.selectByVisibleText(prop.getProperty("from"));
		Thread.sleep(2000);
		Select fmonth=new Select(newtoursOR.getfMonth());
		fmonth.selectByVisibleText(prop.getProperty("fmonth"));
		Thread.sleep(2000);
		Select fday=new Select(newtoursOR.getfDay());
		fday.selectByVisibleText(prop.getProperty("fday"));
		Thread.sleep(2000);
		Select to=new Select(newtoursOR.getTo());
		to.selectByVisibleText(prop.getProperty("to"));
		Thread.sleep(2000);
		Select tmonth=new Select(newtoursOR.gettoMonth());
		tmonth.selectByVisibleText(prop.getProperty("tmonth"));
		Thread.sleep(2000);
		Select tday=new Select(newtoursOR.gettoDay());
		tday.selectByVisibleText(prop.getProperty("tday"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		boolean isEconomy=newtoursOR.getTicketClass().isSelected();
		Assert.assertTrue(isEconomy);
		Thread.sleep(2000);
		Select airline=new Select(newtoursOR.getAirline());
		airline.selectByVisibleText(prop.getProperty("airline"));
		Thread.sleep(2000);
		newtoursOR.getContinueBooking().click();
	}
}
