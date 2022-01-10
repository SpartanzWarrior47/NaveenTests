package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewCartPage {
	
	public WebDriver driver;
	By title=By.xpath("//span[contains(text(),'Your Cart')]");
	By cartCheckOutButton=By.id("checkout");
	By viewCartButton=By.className("shopping_cart_badge");
	By OneItemCount=By.xpath("//span[contains(text(),'1')]");
	
	
	public ViewCartPage(WebDriver driver)
	{
		this.driver=driver;
	}



	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}

	public WebElement getViewCart()
	{
		return driver.findElement(viewCartButton);
		
	}

	public WebElement getCartCheckOut()
	{
		return driver.findElement(cartCheckOutButton);
		
	}
	
	public WebElement getCartCount()
	{
		return driver.findElement(OneItemCount);
		
	}

	
}
