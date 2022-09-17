package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends SigninPage {
	WebDriver driver;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement Add;

	public AddToCart(WebDriver basedriver) {
		super(basedriver);	
		
	}
public void Adding() {
	Add.click();
	
	
}
}
