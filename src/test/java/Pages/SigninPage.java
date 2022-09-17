package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
WebDriver driver;
	
	//--------------------Objects--------------

	@FindBy(id="user-name")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement LoginBtn;
	
	//--------------------Constructor--------------
	public SigninPage(WebDriver basedriver) {
		this.driver=basedriver;
		PageFactory.initElements(basedriver, this);
	}
	
	
	
	//----------------Methods------------------
	
	public void Login(String UserNameValue, String PasswordValue) {
	
		UserName.sendKeys(UserNameValue);
		
		Password.sendKeys(PasswordValue);
		
		LoginBtn.click();
	}


}
