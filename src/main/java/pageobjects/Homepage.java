package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{


	//create one constructor

	public Homepage(WebDriver driver)
	{	
		super(driver);
	}
	

// elements 
	
	// Elements
		@FindBy(xpath = "//span[text()='My Account']")
		WebElement lnkMyaccount;

		@FindBy(linkText = "Register")
		WebElement lnkRegister;

		@FindBy(linkText = "Login")   // Login link added in step6
		WebElement linkLogin;
		
			
		// Action Methods
		public void clickMyAccount() {
			lnkMyaccount.click();
		}

		public void clickRegister() {
			lnkRegister.click();
		}
		
		public void clickLogin()    // added in step6
		{
			linkLogin.click();
		}
}
