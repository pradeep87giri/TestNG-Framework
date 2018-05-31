package object_respository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//li[@id='li_myaccount'])[2]/a")
	WebElement myAccount;

	@FindBy(xpath = "(//li[@id='li_myaccount'])[2]/ul//a[text()=' Login']")
	WebElement login;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[@title='Travelstart']")
	WebElement flights;

	@FindBy(xpath = "(//img[@alt='PHPTRAVELS'])[2]")
	WebElement phpLogo;

	public WebElement myAccount() {
		return myAccount;
	}

	public WebElement LoginLink() {
		return login;
	}

	public WebElement username() {
		return userName;
	}

	public WebElement password() {
		return password;
	}

	public WebElement btnLogin() {
		return btnLogin;
	}

	public WebElement flights() {
		return flights;
	}
	
	public WebElement phpLogo() {
		return phpLogo;
	}
	

}
