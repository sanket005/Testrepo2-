package Pom.Maven;


import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Package1.orangeHRMLoginPage;
import Package1.vtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMLogin {
	public 	WebDriver driver;
	orangeHRMLoginPage login;
	
	@Test
	public void OrangeHRMURL1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login=new orangeHRMLoginPage(driver);
		ResourceBundle RB= ResourceBundle.getBundle("credentials");
		driver.get(RB.getString("orangeHRM_url"));
		login.loginOrangeHRM(RB.getString("username1"), RB.getString("password1"));

	}
	
	@Parameters({"browsername","username","passsword"})
	@Test
	public void OrangeHRMURL(@Optional ("edge") String browsername,@Optional ("")String username,@Optional ("")String password) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); break;
			default:
				System.err.println("Browser name is incorrect");
		}
		
		login=new orangeHRMLoginPage(driver);
	//	ResourceBundle RB= ResourceBundle.getBundle("credentials");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		login.loginOrangeHRM(username,password);

	}
}
