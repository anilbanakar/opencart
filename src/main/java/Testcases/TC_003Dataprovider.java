package Testcases;

import org.apache.commons.math3.analysis.function.Exp;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import utilities.DataProviders;

public class TC_003Dataprovider extends Baseclass {

	
	@Test(dataProvider= "LoginData",dataProviderClass = DataProviders.class)
	public void login(String Email, String password, String exp)
	{
	
try
{
	Homepage hp= new Homepage(driver);
	hp.clickMyAccount();
	
	
	Loginpage lp = new Loginpage(driver);
	lp.setEmail("Email");
	lp.setPassword("password"); 

	lp.clickLogin();
	
	Myaccountpage macc=new Myaccountpage(driver);
	boolean targetpage=macc.isMyAccountPageExists(); // this method is created MyAccountPage
	
	
	if(exp.equals("Valid"))
		{
			macc.clickLogout();
			Assert.assertTrue(true);
		}
	     
       	else 
       	{
       		Assert.assertTrue(false);
       	}
       	
	if (exp.equals("Invalid")) {
		if (targetpage == true) {
			Myaccountpage myaccpage = new Myaccountpage(driver);
			myaccpage.clickLogout();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

} 
	catch (Exception e) 
	{
	Assert.fail();
     }
	
	}
	
}


