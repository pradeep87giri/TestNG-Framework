package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseFunctions{

	public static WebDriver driver;
	public Logger log;
	FileInputStream fis;
	Properties props = new Properties();
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelWSheet;
	XSSFCell Cell;

	// Constructor
	public BaseFunctions() {
		log = LogManager.getLogger(BaseFunctions.class.getName());
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\pgiri3\\eclipse-workspace\\my-project\\src\\main\\java\\reports\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("Select Flight Test");
	}

	// Initialize driver
	public void InitializeWebDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// Load Property file
	public void loadPropFile() throws Exception {
		fis = new FileInputStream(
				"C:\\Users\\pgiri3\\eclipse-workspace\\my-project\\src\\main\\java\\properties\\config.properties");
		props.load(fis);
	}

	// Read properties
	public String getProperty(String key) throws Exception {
		loadPropFile();
		return props.getProperty(key);
	}

	// Set Property
	public void setProperty(String key, String value) throws Exception {
		loadPropFile();
		props.setProperty(key, value);
	}

	// ExplicitWait
	public void ExplicitWait(String xpath, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	// ScreenshotCapture
	public String captureScreenshot(String fileName) throws IOException {
		String directory = "C:\\Users\\pgiri3\\eclipse-workspace\\my-project\\src\\main\\java\\screenshots\\";
		String destFilePath = directory + fileName+".png";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(destFilePath);
		FileUtils.copyFile(srcFile, destFile);
		return destFilePath;
	}
	
	@DataProvider
	public Object[][] readData(String excelPath) throws Exception {
		FileInputStream excelFile = new FileInputStream(excelPath);
		ExcelWBook = new XSSFWorkbook(excelFile);
		return null;
	}

}
