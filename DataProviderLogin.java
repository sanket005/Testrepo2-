package Pom.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Package1.orangeHRMLoginPage;
import Package1.vtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DataProviderLogin{
	
WebDriver driver;
vtigerLoginPage login;
orangeHRMLoginPage login1;
	/*    Vtiger login by using TestNG dataProvider concept  */
	@Test(dataProvider="VTDataprovider")
	public void vtigerLoginMethod2(String username,String password) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		login=new vtigerLoginPage(driver);
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		login.login(username,password);
		
		
	}
	@DataProvider(name="VTDataprovider", parallel=true)
	public Object[][] Vtigerdataprovider() {
		Object[][] data=new Object[2][2];
		data[0][0]= "Sanket";
		data[0][1]="Patil";
		data[1][0]="admin";
		data[1][1]="Test@123";
		return data;
	}
	

	/*    Vtiger login by using TestNG dataProvider concept  */
	@Test(dataProvider="ORHMDataprovider")
	public void OrangeHRMlogin(String username,String password) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		login1=new orangeHRMLoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		login1.loginOrangeHRM(username,password);
		
		
	}
	@DataProvider(name="ORHMDataprovider",  parallel=true)
	public Object[][] ORHMdataprovider() {
		Object[][] data=new Object[2][2];
		data[0][0]= "Sanket";
		data[0][1]="Patil";
		data[1][0]="admin";
		data[1][1]="Test@123";
		return data;
	}
	
	@Test
	public void TestRepogit() {
		System.out.println("I want to override the eclipse commit as B user");
	}

	

}
