package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registrationpage extends Basepage {

	public Registrationpage(WebDriver driver) {
		super(driver);
		
	}

	//Elements 
	By first_name =By.name("firstname");
	By last_name = By.name("lastname");
	By email=     By.name("email");
	By telephone= By.name("telephone");
	By password=  By.name("password");
	By confirm=   By.name("confirm");
	By agree=     By.name("agree");
	By cnt=       By.xpath( "//input[@value='Continue']");
	

	//actions methods
	   public void setfirstname(String firstname)
	   {
		   driver.findElement(first_name).sendKeys(firstname);
	   }
	 
	   public void setlastname(String lastname)
	   {
		   driver.findElement(last_name).sendKeys(lastname);
	   }
	   
	   public void setemail(String emaild)
	   {
		   driver.findElement(email).sendKeys(emaild);	   
	   }
	   
	   public void settelephone(String no)
	   {
		   driver.findElement(telephone).sendKeys(no);
	   }
	
	   public void setpassword(String pwd)
	   {
		   driver.findElement(password).sendKeys(pwd);
	   }
	
	   public void confirm()
	   {
		   driver.findElement(confirm).click();
	   }
     
	   public void agree()
	   {
		   driver.findElement(agree).click();
	   }

       public void clickcontinue()
       {
    	   driver.findElement(cnt).click();
       }
       

}
