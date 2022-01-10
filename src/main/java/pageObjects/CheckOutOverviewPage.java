package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutOverviewPage {

	public WebDriver driver;

	By title=By.xpath("//span[contains(text(),'Checkout: Overview')]");
	By FinishButton=By.id("finish");
	
	public CheckOutOverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}


		
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	public WebElement getFinish()
	{
		return driver.findElement(FinishButton);
		
	}

}
