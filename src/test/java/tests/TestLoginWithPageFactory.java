package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.HomePage;
import pageFactory.Login;

public class TestLoginWithPageFactory {
	
	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	String path;
	
	@BeforeTest
	public void setup() {
		path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}
	
	@Test
	public void test_Home_Page_Appear_Correct() {
		objLogin = new Login(driver);
		//Verify login page title
		String loginPageMessage = objLogin.getLoginMessage();
		System.out.println(loginPageMessage);
		AssertJUnit.assertTrue(loginPageMessage.contains("Please enter"));
		
		//To login to application
		objLogin.loginToApplication("j2ee", "j2ee");
		//go to next page
		objHomePage = new HomePage(driver);
		//Verify the home page 
		AssertJUnit.assertTrue(objHomePage.getHomePageDashboardUserName().contains("ABC"));
	}


}
