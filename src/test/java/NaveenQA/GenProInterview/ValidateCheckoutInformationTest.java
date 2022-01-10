package NaveenQA.GenProInterview;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CheckOutInformationPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import resources.base;

public class ValidateCheckoutInformationTest extends base{
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	//Validations for Verify CheckoutInformation page
	@Test
	  
	public void VerifyCheckoutInfo()
	
	{
		LoginPage l = new LoginPage(driver);
		ProductsPage PP = new ProductsPage(driver);
		ViewCartPage VC=new ViewCartPage(driver);
		l.getUserName().sendKeys("standard_user");
		l.getPasword().sendKeys("secret_sauce");
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getTitle()));
		PP.getAddtoCart().click();
		VC.getViewCart().click();
		VC.getCartCheckOut().click();
		
		
		CheckOutInformationPage info=new CheckOutInformationPage(driver);
		if(info.getTitle().getText().equalsIgnoreCase("Checkout: Your Information"))
		{
			System.out.println("Page is navigated to Checkout Information page successfully");
			info.getFirstName().sendKeys("Tom");
			info.getLastName().sendKeys("Test");
			info.getZipCode().sendKeys("98101");
		}
		else
		{
			System.out.println("Navigate to Checkout Information page failed ");
		}
		Boolean visibleState =info.getContinue().isDisplayed();
		System.out.println("Continue Button visibility is: "+visibleState);
		if(visibleState)
		{
		    Boolean status =info.getContinue().isEnabled();
		    System.out.println("The status of Continue Button is: "+status);
		 
		    //If continue Button is enabled click on it
		    if(status)
		    {
		    	info.getContinue().click();
		    }
		    else
		    {
		    	System.out.println("Continue button is not enabled");
		    }
		}
		else
		{
			System.out.println("Continue button is not displayed");
		}
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}


}
