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

import pageObjects.CheckOutInformationPage;
import pageObjects.CheckOutOverviewPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import resources.base;

public class ValidateCheckoutOverviewTest extends base{

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	//Validations for checkout Overview Page
	@Test
	public void ValidateOverview()
	{
		LoginPage l = new LoginPage(driver);
		ProductsPage PP = new ProductsPage(driver);
		ViewCartPage VC=new ViewCartPage(driver);
		CheckOutInformationPage info=new CheckOutInformationPage(driver);
		CheckOutOverviewPage overview=new CheckOutOverviewPage(driver);
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
			System.out.println("Navigated to Checkout Overview page successfully");
			Boolean visibleState =overview.getFinish().isDisplayed();
			System.out.println("Finish Button visibility is: "+visibleState);
			if(visibleState)
			{
			    Boolean status =overview.getFinish().isEnabled();
			    System.out.println("The status of Finish Button is: "+status);
			 
			    //If Finish Button is enabled click on it
			    if(status)
			    {
			    	overview.getFinish().click();
			    }
			    else
			    {
			    	System.out.println("Finish button is not enabled");
			    }
			}
			else
			{
				System.out.println("Finish button is not displayed");
			}
			
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
