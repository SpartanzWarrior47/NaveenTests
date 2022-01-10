package NaveenQA.GenProInterview;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CheckOutCompletePage;
import pageObjects.CheckOutInformationPage;
import pageObjects.CheckOutOverviewPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import resources.base;

public class CheckOutCompleteTest extends base{
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	//Validations for Checkout Complete Page
	@Test
	public void ValidateCheckOutComplete()
	{
		LoginPage l = new LoginPage(driver);
		ProductsPage PP = new ProductsPage(driver);
		ViewCartPage VC=new ViewCartPage(driver);
		CheckOutInformationPage info=new CheckOutInformationPage(driver);
		CheckOutOverviewPage overview=new CheckOutOverviewPage(driver);
		CheckOutCompletePage complete=new CheckOutCompletePage(driver);
		l.getUserName().sendKeys("standard_user");
		l.getPasword().sendKeys("secret_sauce");
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getTitle()));
		PP.getAddtoCart().click();
		VC.getViewCart().click();
		VC.getCartCheckOut().click();
		
		info.getFirstName().sendKeys("Tom");
			info.getLastName().sendKeys("Test");
			info.getZipCode().sendKeys("98101");
			info.getContinue().click();
			AssertJUnit.assertEquals(overview.getTitle().getText(), "CHECKOUT: OVERVIEW");
			overview.getFinish().click();
			AssertJUnit.assertEquals(complete.getTitle().getText(), "THANK YOU FOR YOUR ORDER");
			System.out.println("Page navigated to checkout complete page");
			Boolean visibleState =complete.getHome().isDisplayed();
			System.out.println("Back to Home Button visibility is: "+visibleState);
			if(visibleState)
			{
			    Boolean status =complete.getHome().isEnabled();
			    System.out.println("The status of Back to Home Button is: "+status);
			 
			    //If Back to Home Button is enabled click on it
			    if(status)
			    {
			    	complete.getHome().click();
			    }
			    else
			    {
			    	System.out.println("Back to Home button is not enabled");
			    }
			}
			else
			{
				System.out.println("Back to Home button is not displayed");
			}
			
			AssertJUnit.assertEquals(PP.getTitle().getText(), "PRODUCTS");
			System.out.println("Navigated to Home Page succesfully");
			
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
