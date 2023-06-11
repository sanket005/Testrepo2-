package Pom.Maven;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Package1.vtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerLogin {
public WebDriver driver;
vtigerLoginPage login;
/*    Vtiger login by POM concept  */

public void vtigerLoginMethod1() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	login=new vtigerLoginPage(driver);
	ResourceBundle rb=ResourceBundle.getBundle("credentials");
	driver.get(rb.getString("vtiger_url"));
	login.login(rb.getString("username"), rb.getString("password"));
}

/*    Vtiger login by using Test NG parameter concept  */
@Parameters({"browsername","username","password"})
@Test
public void vtigerLoginMethod(@Optional ("chrome") String browsername, String username, String password) {
	switch(browsername.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		default:
			System.out.println("browsername is incorrect"); break;
	}

	login=new vtigerLoginPage(driver);
	driver.get("https://demo.vtiger.com/vtigercrm/index.php");
	login.login(username,password);
}
}
