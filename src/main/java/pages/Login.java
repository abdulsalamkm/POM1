package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	
	By user = By.name("username");
	By password = By.name("password");
	By message= By.xpath("//p[contains(text(),'Please enter')]");
	By login=By.name("signon");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	//setusername in textbox
	public void setUserName(String strUserName) {
		driver.findElement(user).sendKeys(strUserName);
	}
	
	//set Password in password text box
	public void setPassword(String strPassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//click on login button
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//get the message of login page
	public String getLoginMessage() {
		return driver.findElement(message).getText();
	}
	
	//This method will be exposed to the test case to login to application
	
	public void loginToApplication(String strUserName, String strPassword) {
		//fill user name
		this.setUserName(strUserName);
		//fill password
		this.setPassword(strPassword);
		//click login button
		this.clickLogin();
		
	}
}
