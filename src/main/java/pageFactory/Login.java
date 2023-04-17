package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//All webelements are identified by @FindBy Annotation

	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath=("//p[contains(text(),'Please enter')]"))
	WebElement messageText;
	
	@FindBy(name="signon")
	WebElement login;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //This initELement will create all web elements
	}
	
	//setusername in textbox
	public void setUserName(String strUserName) {
		username.sendKeys(strUserName);
	}
	
	//set Password in password text box
	public void setPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}
	
	//click on login button
	public void clickLogin() {
		login.click();
	}
	
	//get the message of login page
	public String getLoginMessage() {
		return messageText.getText();
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
