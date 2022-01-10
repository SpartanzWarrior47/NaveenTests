package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutInformationPage {
	public WebDriver driver;
	By FirstName=By.name("firstName");
	By LastName=By.name("lastName");
	By ZipCode=By.id("postal-code");
	By ContinueButton=By.id("continue");
	By title=By.xpath("//span[contains(text(),'Checkout: Your Information')]");
	
	public CheckOutInformationPage(WebDriver driver)
	{
		this.driver=driver;
	}



	public WebElement getFirstName()
	{
		return driver.findElement(FirstName);
		
	}

	public WebElement getLastName()
	{
		return driver.findElement(LastName);
		
	}

	public WebElement getZipCode()
	{
		return driver.findElement(ZipCode);
		
	}
	
	public WebElement getContinue()
	{
		return driver.findElement(ContinueButton);
		
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}

}
