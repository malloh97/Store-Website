package SanityTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.Signin_PO;

public class Signin extends ConfigData {
	 
	Signin_PO Sign;
	
	@BeforeMethod
	public void beforeMethod()
	{
		Sign = new Signin_PO(); 
		getDriver();
		ReadData();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		teardown();
	}
	
	@Test
	public void SignIn()
	{
		Sign.CLickOn_SignIn();
		Sign.Set_email();
		Sign.ClickOn_CreateAccount();
		Sign.Fill_Title();
		Sign.Fill_FirstName();
		Sign.Fill_LastName();
		Sign.Fill_Password();
		Sign.Fill_DateOfBirth();
		Sign.ClickOn_Newletters();
		Sign.ClickOn_SpecialOffers();
		Sign.Fill_FirstNameAddress();
		Sign.Fill_LastNameAddress();
		Sign.Fill_Company();
		Sign.Fill_Address1();
		Sign.Fill_Address2();
		Sign.Fill_City();
		Sign.Fill_State();
		Sign.Fill_ZipCode();
		Sign.Fill_Company();
		Sign.Fill_HomePhoneNumber();
		Sign.Fill_MobilePhoneNumber();
		Sign.Fill_FutureAdress();
		Sign.ClickOnSubmit();
		Sign.IsAccountAdded();
	}
}