package NaveenQA.GenProInterview;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import resources.base;

public class LogoutTest extends base {

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
//Validations for Logout
	@Test
	public void ValidateLogout() {
		LoginPage l = new LoginPage(driver);
		ProductsPage PP = new ProductsPage(driver);

		l.getUserName().sendKeys("standard_user");
		l.getPasword().sendKeys("secret_sauce");
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getTitle()));
		PP.getMenu().click();
		wait.until(ExpectedConditions.visibilityOf(PP.getLogout()));
		Boolean visibleState = PP.getLogout().isDisplayed();
		System.out.println("Logout Button visibility is: " + visibleState);
		if (visibleState) {

			System.out.println("Logout button is displayed");
			PP.getLogout().click();
		} else {
			System.out.println("Logot button is not displayed");
		}
		if (l.getLoginBtn().isDisplayed()) {
			System.out.println("User Logged out successfully");
		} else {
			System.out.println("Logout Failed");
		}
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
