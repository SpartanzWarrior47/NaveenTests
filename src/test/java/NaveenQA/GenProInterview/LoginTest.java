package NaveenQA.GenProInterview;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import resources.base;

public class LoginTest extends base {

	
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}

	//Method to Validate all usernames and passwords provided
	
	@Test(dataProvider = "getData")

	public void UsersValidation(String username, String password, String text) throws IOException {


		ProductsPage PP = new ProductsPage(driver);
		LoginPage l = new LoginPage(driver);
		l.getUserName().sendKeys(username);
		l.getPasword().sendKeys(password);
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getAddtoCart()));
		AssertJUnit.assertEquals(PP.getTitle().getText(), "PRODUCTS");
		System.out.println(text);
		
	}
	
	
//Data provider method for all usernames and passwords provided
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[4][3];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		data[0][2] = "Verified Standard user Login";
		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		data[1][2] = "Verified Locked out user Login";
		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";
		data[2][2] = "Verified Problem user Login";
		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";
		data[3][2] = "Verified Performance Glitch user Login";

		return data;

	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
