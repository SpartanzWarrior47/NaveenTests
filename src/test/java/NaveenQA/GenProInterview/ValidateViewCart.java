package NaveenQA.GenProInterview;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import resources.base;

public class ValidateViewCart extends base {
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
//Validations for View Cart Page
	@Test
	public void ViewCart() {
		LoginPage l = new LoginPage(driver);
		ProductsPage PP = new ProductsPage(driver);
		ViewCartPage VC=new ViewCartPage(driver);
		l.getUserName().sendKeys("standard_user");
		l.getPasword().sendKeys("secret_sauce");
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getTitle()));
		PP.getAddtoCart().click();
		wait.until(ExpectedConditions.visibilityOf(PP.RemoveProduct()));
		if(VC.getCartCount().isDisplayed())
		{
			System.out.println("One Item added to the cart");
		}
		VC.getViewCart().click();
		
		AssertJUnit.assertEquals(VC.getTitle().getText(), "YOUR CART");
		System.out.println("View Cart Page displayed successfully");
		Boolean visibleState =VC.getCartCheckOut().isDisplayed();
		System.out.println("The CheckOut Button visibility is: "+visibleState);
		if(visibleState)
		{
		    Boolean status =VC.getCartCheckOut().isEnabled();
		    System.out.println("The status of CheckOut Button is: "+status);
		 
		    //If Check out Button is enabled click on it
		    if(status)
		    {
		    	VC.getCartCheckOut().click();
		    }
		    else
		    {
		    	System.out.println("Check out button is not enabled");
		    }
		}
		else
		{
			System.out.println("Check out button is not displayed");
		}
		
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
