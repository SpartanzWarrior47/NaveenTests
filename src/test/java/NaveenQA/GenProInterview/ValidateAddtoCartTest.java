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

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import resources.base;

public class ValidateAddtoCartTest extends base{
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	//Validation for Adding an item to Cart
	@Test
	public void ProductAddtoCart()
	{
		LoginPage l=new LoginPage(driver);
		ProductsPage PP=new ProductsPage(driver);
		l.getUserName().sendKeys("standard_user");
		l.getPasword().sendKeys("secret_sauce");
		l.getLoginBtn().click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(PP.getAddtoCart()));
		Boolean visibleState =PP.getAddtoCart().isDisplayed();
		System.out.println("The Add to Cart Button visibility is: "+visibleState);
		if(visibleState)
		{
		    Boolean status =PP.getAddtoCart().isEnabled();
		    System.out.println("The status of Add to Cart Button is: "+status);
		 
		    //If Add to Cart Button is enabled click on it
		    if(status)
		    {
		      PP.getAddtoCart().click();
		    }
		    else
		    {
		    	System.out.println("Add to Cart button is not enabled");
		    }
		}
		else
		{
			System.out.println("Add to Cart button is not displayed");
		}
		
		wait.until(ExpectedConditions.visibilityOf(PP.RemoveProduct()));
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
