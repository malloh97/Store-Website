package SanityTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.AddEmail_forNewsletter_PO;

public class AddEmail_forNewsletter extends ConfigData {
	
	AddEmail_forNewsletter_PO Email; 
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		Email = new AddEmail_forNewsletter_PO();
		getDriver();
		ReadData();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void Add_EmailFor_News()
	{
		Email.ScrollToEmailField();
		Email.Fill_Email();
		Email.ClickOnSubmitArrow();
		Email.CheckTheNotification();
	}
	
	@Test(priority=2)
	public void Add_SameEmailFor_News()
	{
		Email.ScrollToEmailField();
		Email.Fill_Email();
		Email.ClickOnSubmitArrow();
		Email.CheckExistingEmail_Notification();
	}

}
