package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import utilities.DataProviders;

public class TC_002Logintest extends Baseclass {

	
	@Test (groups= {"Sanity","Master"}) //Step8 groups added
	public void login()
	{
		try
		{
		
		Homepage hp= new Homepage(driver);
		hp.clickMyAccount();
		//add hp.clicklogin(); // need to add this in login page 
		
		Loginpage lp = new Loginpage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword("password"); 

		lp.clickLogin();
		
		Myaccountpage macc=new Myaccountpage(driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
					
		Assert.assertEquals(targetpage, true);
		
	}	
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info(" Finished TC_002_LoginTest");
				
		
	}
	
}
