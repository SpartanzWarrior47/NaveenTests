package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

	public WebDriver driver;
	By title = By.xpath("//span[contains(text(),'Products')]");
	By viewCartButton = By.className("shopping_cart_badge");
	By AddtoCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[last()]");
	By RemoveProductButton = By.xpath("//button[contains(text(),'Remove')]");
	By menuButton = By.id("react-burger-menu-btn");
	By LogoutButton = By.id("logout_sidebar_link");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);

	}

	public WebElement getViewCart() {
		return driver.findElement(viewCartButton);

	}

	public WebElement getAddtoCart() {
		return driver.findElement(AddtoCartButton);

	}

	public WebElement getMenu() {
		return driver.findElement(menuButton);

	}

	public WebElement RemoveProduct() {
		return driver.findElement(RemoveProductButton);

	}
	
	public WebElement getLogout() {
		return driver.findElement(LogoutButton);

	}

}
