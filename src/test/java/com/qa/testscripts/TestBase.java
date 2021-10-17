package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.NewtoursPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	WebDriver driver;
	NewtoursPages newtoursOR;
	JavascriptExecutor js;
	FileInputStream file;
	Properties prop;
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser,String url) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("internetexplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		newtoursOR=new NewtoursPages(driver);
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		js=(JavascriptExecutor)driver;
		file=new FileInputStream("C:\\Users\\KUNDAN KUMAR RAI\\Selenium\\VirtusaTestNG_Newtours_Parameter_Properties\\src\\test\\java\\com\\qa\\testdata\\Data.properties");
		prop=new Properties();
		prop.load(file);
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
