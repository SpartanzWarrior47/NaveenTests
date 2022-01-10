package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutCompletePage {

	public WebDriver driver;

	By title=By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");
	By BackHome=By.name("back-to-products");
	
	public CheckOutCompletePage(WebDriver driver)
	{
		this.driver=driver;
	}


		
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	public WebElement getHome()
	{
		return driver.findElement(BackHome);
		
	}
}
