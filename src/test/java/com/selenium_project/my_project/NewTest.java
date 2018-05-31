package com.selenium_project.my_project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import base.BaseFunctions;
import libraries.ApplicationFunctions;
import object_respository.FlightPage;
import object_respository.LoginPage;

public class NewTest extends BaseFunctions {

	LoginPage login;
	FlightPage flight;
	ApplicationFunctions app;
	String URL;
	String uName;
	String uPwd;
	String destImgPath;

	@BeforeClass
	public void beforeClass() throws Exception {
		URL = getProperty("url");
		uName = getProperty("username");
		uPwd = getProperty("password");
		InitializeWebDriver();
		login = new LoginPage(driver);
		flight = new FlightPage(driver);
		app = new ApplicationFunctions();
		driver.get(URL);
	}
	
	@Test
	public void logIn() throws Exception {
		app.AppLogin(uName, uPwd);
		String img = captureScreenshot("Log In");
		test.pass("Log in : "+test.addScreenCaptureFromPath(img));
		ExplicitWait("//a[@href='#bookings']", 5);
//		login.phpLogo().click();
		login.flights().click();
		log.info("Clicked on flights tab");
		test.pass("Clicked on flights tab successfully");		
	}

	@Test
	public void searchFlight() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'travelstartIframe')]")));
		app.selectLocation(flight.departure(),"DEL");
		app.selectLocation(flight.arrival(),"PNQ");
		app.selectDate(flight.departDate(), "Apr", "26");
		app.selectDate(flight.returnDate(), "May", "15");
		flight.btnSearch().click();
	}
	
	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.quit();
	}
}
