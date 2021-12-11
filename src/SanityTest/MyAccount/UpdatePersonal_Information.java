package SanityTest.MyAccount;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.MyAccount.Add_Update_DeleteAddress_PO;
import PageObjectModel.MyAccount.UpdatePersonal_Information_PO;

public class UpdatePersonal_Information extends ConfigData {
	
	Add_Update_DeleteAddress_PO Login;
	UpdatePersonal_Information_PO Update;
	
	@BeforeTest
	@Parameters({"Browser"})
	public void beforeTest(String Browser)
	{
		getDriver(Browser);
	}

	@AfterTest
	public void afterTest()
	{
		teardown();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		Login = new Add_Update_DeleteAddress_PO();
		Update = new UpdatePersonal_Information_PO();
		ReadData(); 
	}
	
	@Test(priority = 1, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Login()
	{
		Login.ClickOnSignin();
		Login.Fill_Email();
		Login.Fill_Password();
		Login.ClickOnSigninButton();
	}

	@Test(priority = 2, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void UpdatePersonalnfo()
	{
		Update.ClickOnMyPersonalInfo();
		Update.Fill_FirstName();
		Update.Fill_LastName();
		Update.Fill_CurrentPassword();
		Update.Fill_NewPassword();
		Update.ConfirmationPassword();
		Update.SaveUpdating();
		Update.CheckNotification();
		
	}
	
	
	
	
	
	
	
	
	
	
}