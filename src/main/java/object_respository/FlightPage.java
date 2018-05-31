package object_respository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {
	WebDriver driver;

	public FlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@id,'airports-inline-orig')]")
	WebElement departure;

	@FindBy(xpath = "//input[contains(@id,'airports-inline-dest')]")
	WebElement arrival;

	@FindBy(xpath = "//span[contains(@id,'depart-date-link')]")
	WebElement departDate;

	@FindBy(xpath = "//span[contains(@id,'return-date-link')]")
	WebElement returnDate;

	@FindBy(id = "search-for-flights-button")
	WebElement btnSearch;
	
	@FindBy(xpath = "//p[@class='sr-filters__subheading']")
	WebElement txtFilters;
	
	@FindBy(xpath = "//h4[@class='datepicker__title ng-binding']")
	WebElement month;
	
	@FindBy(xpath = "//button[@class='datepicker__next-month']")
	WebElement nextMonth;

	public WebElement departure() {
		return departure;
	}

	public WebElement arrival() {
		return arrival;
	}

	public WebElement departDate() {
		return departDate;
	}

	public WebElement returnDate() {
		return returnDate;
	}
	
	public WebElement month() {
		return month;
	}
	
	public WebElement nextMonth() {
		return nextMonth;
	}
	
	public WebElement btnSearch() {
		return btnSearch;
	}
	
	public WebElement txtFilters() {
		return txtFilters;
	}

}
