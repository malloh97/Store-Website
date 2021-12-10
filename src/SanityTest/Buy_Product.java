package SanityTest;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.Buy_Product_PO;
import PageObjectModel.Signin_PO;

public class Buy_Product  extends ConfigData {
	
	Buy_Product_PO Cart; 
	Signin_PO Sign; 
	
	@BeforeTest
	public void beforeTest()
	{
		getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		Cart = new Buy_Product_PO();
		Sign = new Signin_PO();
		ReadData();
	}
	
	@AfterTest
	public void afterTest()
	{
		teardown();
	}
	
	@Test(priority=1, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void ChooseProduct()
	{
		Cart.ClickOn_WomenCategory();
		Cart.Fill_Category();
		Cart.Fill_Size();
		Cart.Fill_Compositions();
		Cart.Fill_Styles();
		Cart.Fill_Properties();
		//Cart.Fill_Price();
		Cart.ChangeView_ToList();
		Cart.ClickOnFirstProduct();
		Cart.ClickOnSecondProduct();
	}
	
	@Test(priority=2, dependsOnMethods= {"ChooseProduct"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Summary()
	{
		Cart.Increase_Qty();
		Cart.ClickOnProceedtoCheckout();
	}
	
	@Test(priority=3, dependsOnMethods= {"Summary"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Signin()
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
		//Sign.IsAccountAdded();

	}
	
	
	@Test(priority=4, dependsOnMethods= {"Signin"}) 
	public void Address()
	{
		Cart.ClickOnProceedtoCheckout();
		Cart.FillNote_OnOrder();
		Cart.ClickOnProcessAddress();
	}
	
	@Test(priority=5, dependsOnMethods= {"Address"}) 
	public void Shipping()
	{
		Cart.CLickOnTerms_of_Service();
		Cart.ClickOnCheckout();
	}  

	@Test(priority=6, dependsOnMethods= {"Shipping"}) 
	public void Payment()
	{
		Cart.ChoosePayment();
		Cart.ClickOnConfirmOrder();
		Cart.IsOrderCompleted();
	}
	

}
