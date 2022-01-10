package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton=By.name("login-button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserName() {
		return driver.findElement(username);
	}

	public WebElement getPasword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(loginButton);
	}

}
