package libraries;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseFunctions;
import object_respository.*;

public class ApplicationFunctions extends BaseFunctions {

	LoginPage login = new LoginPage(driver);
	FlightPage flight = new FlightPage(driver);

	public void AppLogin(String uName, String uPwd) throws Exception {
		login.myAccount().click();
		login.LoginLink().click();
		ExplicitWait("//input[@name='username']", 4);
		login.username().sendKeys(uName);
		login.password().sendKeys(uPwd);
		login.btnLogin().click();
		log.debug("Logged in application");
	}

	public void selectLocation(WebElement element, String location) {
		element.click();
		element.sendKeys(location);
		WebElement locElement = driver.findElement(By.xpath("//strong[text()='" + location + "']"));
		locElement.click();
	}

	public void selectDate(WebElement element, String Month, String day) {
		element.click();
		
//		Select Month
		while (true) {
			if (flight.month().getText().contains(Month)) {
				break;
			} else {
				flight.nextMonth().click();
			}
		}
		
//		Select Day
		WebElement dayElement = driver.findElement(By.xpath("//button[text()='" + day + "']"));
		dayElement.click();
	}
}
