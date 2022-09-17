package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AddToCart;
import Pages.SigninPage;



public class TestCases extends BaseClass{
	
	
	@Test
	public void TitleTest() {
		boolean Title = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).isDisplayed();
		Assert.assertTrue(Title);
		
	}
	
	@Test
	public void RtLoginTest() {
		SigninPage Lp= new SigninPage(driver);
		Lp.Login("standard_user","secret_sauce");
		
		WebElement Error1 = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
		String ActError1 = Error1.getText();
		String ExpError1 = "PRODUCTS";
		Assert.assertEquals(ActError1,ExpError1);
		
		//assertion using URL
		String ActUrl=driver.getCurrentUrl();
		String ExpUrl="https://www.saucedemo.com/inventory.html";
		
		Assert.assertEquals(ActUrl,ExpUrl);
	}
	
	@Test
	@Parameters({"UserName","Password"})
	public void WrgLoginTest(String UsrName, String Pwd) {
		SigninPage Lp= new SigninPage(driver);
		Lp.Login("UsrName","Pwd");
		
		WebElement Error2 = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"));
		String ActError2 = Error2.getText();
		String ExpError2 = "Epic sadface: Username and password do not match any user in this service";
	
		Assert.assertEquals(ActError2,ExpError2);
	}
	@Test
	@Parameters({"Name"})
	public void Cart(String product) throws InterruptedException {
		AddToCart Lp= new AddToCart(driver);
		Lp.Login("standard_user","secret_sauce");
		
		if(product.equals("Sauce Labs Backpack")) {
		WebElement Pro1 = driver.findElement(By.id("item_4_title_link"));
		Pro1.isDisplayed();
		Lp.Adding();
		
		Thread.sleep(1000);
	
		boolean cart=driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).isDisplayed();
		Assert.assertTrue(cart);
				
		}
		
		
			
		
		
		
		
		
	}
}
