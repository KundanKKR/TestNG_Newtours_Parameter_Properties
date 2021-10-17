package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewtoursPages
{
	WebDriver driver;
	public NewtoursPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userName")
	WebElement userName;
	public WebElement getUserName()
	{
		return userName;
	}
	
	@FindBy(name="password")
	WebElement password;
	public WebElement getPassword()
	{
		return password;
	}
	
	@FindBy(name="submit")
	WebElement submitBtn;
	public WebElement getSubmitBtn()
	{
		return submitBtn;
	}
	
	@FindBy(linkText="Flights")
	WebElement flight;
	public WebElement getFlight()
	{
		return flight;
	}
	
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement roundTrip;
	public WebElement getRoundTrip()
	{
		return roundTrip;
	}
					
	@FindBy(name="passCount")
	WebElement passenger;
	public WebElement getPassenger()
	{
		return passenger;
	}
	
	@FindBy(name="fromPort")
	WebElement from;
	public WebElement getFrom()
	{
		return from;
	}
	
	@FindBy(name="fromMonth")
	WebElement fMonth;
	public WebElement getfMonth()
	{
		return fMonth;
	}
	
	@FindBy(name="fromDay")
	WebElement fDay;
	public WebElement getfDay()
	{
		return fDay;
	}
	
	@FindBy(name="toPort")
	WebElement to;
	public WebElement getTo()
	{
		return to;
	}
	
	@FindBy(name="toMonth")
	WebElement toMonth;
	public WebElement gettoMonth()
	{
		return toMonth;
	}
	
	@FindBy(name="toDay")
	WebElement toDay;
	public WebElement gettoDay()
	{
		return toDay;
	}
	
	@FindBy(xpath="//td/font[1]/input[1]")
	WebElement ticketClass;
	public WebElement getTicketClass()
	{
		return ticketClass;
	}
	
	@FindBy(xpath="//*[@name='airline']")
	WebElement airline;
	public WebElement getAirline()
	{
		return airline;
	}
	
	@FindBy(name="findFlights")
	WebElement continueBooking;
	public WebElement getContinueBooking()
	{
		return continueBooking;
	}
}
