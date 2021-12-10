package SanityTest.MyAccount;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.Signin_PO;
import PageObjectModel.MyAccount.Add_Update_DeleteAddress_PO;

public class Add_Update_DeleteAddress extends ConfigData {
	
	Add_Update_DeleteAddress_PO address; 
	Signin_PO send;
	
	@BeforeTest
	public void beforeTest()
	{
		getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		ReadData();
		address = new Add_Update_DeleteAddress_PO();
		send = new Signin_PO();
	}
	
	@AfterTest
	public void afterTest()
	{
		teardown();
	}
	
	@Test(priority=1, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Login()
	{
		address.ClickOnSignin();
		address.Fill_Email();
		address.Fill_Password();
		address.ClickOnSigninButton();
	}
	
	@Test(priority=2, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void AddNewAddress()
	{
		address.Open_MyAddress();
		address.ClickOnAddNewAddress();
		send.Fill_FirstNameAddress();
		send.Fill_LastNameAddress();
		send.Fill_Company();
		send.Fill_Address1();
		send.Fill_Address2();
		send.Fill_City();
		send.Fill_State();
		send.Fill_ZipCode();
		send.Fill_HomePhoneNumber();
		send.Fill_MobilePhoneNumber();
		send.Fill_Additional_information();
		send.Fill_FutureAdress();
		address.ClickOnSave();
		address.IsNewAddressAdded();
	}
	
	@Test(priority=3, dependsOnMethods= {"AddNewAddress"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void UpdateAddress()
	{
		address.ClickOnUpdate();
		address.Update_City();
		address.Update_HomePhoneNumber();
		address.Update_ZipCode();
		address.ClickOnSave();
	}
	
	@Test(priority=4, dependsOnMethods= {"UpdateAddress"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void DeleteAddress()
	{
		address.ClickOnDelete();
		address.ConfirmDeleteAddress();
		address.IsAddressDeleted();
	}

}