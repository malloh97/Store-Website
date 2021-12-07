package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;



public class Signin_PO extends ConfigData {

//	public SendWordToSearch_PO (ConfigData driver)
//	{
//		this.driver = driver; 
//	}
//	
	
	public void CLickOn_SignIn()
	{
		ClickOnBy_Xpath("//a[contains(@class,'login')]");
	}
	
	public void Set_email()
	{
		SendKeysBy_Id("email_create", prop.getProperty("email"));
	}
	
	public void ClickOn_CreateAccount()
	{
		ClickOnBy_Id("SubmitCreate");
	}
	
	public void Fill_Title()
	{
		ClickOnBy_Id("id_gender1");
	}
	
	public void Fill_FirstName()
	{
		SendKeysBy_Id("customer_firstname", prop.getProperty("First_Name"));
	}
	
	public void Fill_LastName()
	{
		SendKeysBy_Id("customer_lastname", prop.getProperty("Last_Name"));
	}
	
	
	public void Fill_Password()
	{
		SendKeysBy_Id("passwd", prop.getProperty("Password"));
	}
	
	
	public void Fill_DateOfBirth()
	{
		SelectFrom_ByIndex("days", 3); // fill day 
		SelectFrom_ByIndex("months", 3); // fill month
		SelectFrom_ByIndex("years", 25); // fill year
	}
	
	public void ClickOn_Newletters()
	{
		ClickOnBy_Id("newsletter"); // Sign up for our newsletter!
	}
	
	public void ClickOn_SpecialOffers()
	{
		ClickOnBy_Id("optin"); // Receive special offers from our partners!
	}
	
	public void Fill_FirstNameAddress()
	{
		SendKeysBy_Id("firstname", prop.getProperty("FirstNameAddress"));
	}
	
	public void Fill_LastNameAddress()
	{
		SendKeysBy_Id("lastname", prop.getProperty("LastNameAddress"));
	}
	
	public void Fill_Company()
	{
		SendKeysBy_Id("company", prop.getProperty("Company"));
	}
	
	public void Fill_Address1()
	{
		SendKeysBy_Id("address1", prop.getProperty("Address1"));
	}
	
	public void Fill_Address2()
	{
		SendKeysBy_Id("address2", prop.getProperty("Address2"));
	}
	
	public void Fill_City()
	{
		SendKeysBy_Id("city", prop.getProperty("City"));
	}
	
	public void Fill_State()
	{
		SelectFrom_VisibleText("id_state", prop.getProperty("State"));
	}
	
	public void Fill_ZipCode()
	{
		SendKeysBy_Id("postcode", prop.getProperty("ZipCode"));
	}
	
	public void Fill_HomePhoneNumber()
	{
		SendKeysBy_Id("phone", prop.getProperty("HomePhone"));
	}
	
	public void Fill_MobilePhoneNumber()
	{
		SendKeysBy_Id("phone_mobile", prop.getProperty("MobilePhone"));
	}
	
	public void Fill_Additional_information()
	{
		SendKeysBy_Id("other", prop.getProperty("FutureAddress"));
	}
	
	public void Fill_FutureAdress()
	{
		SendKeysBy_Id("alias", prop.getProperty("FutureAddress")); 
	}
	
	public void ClickOnSubmit()
	{
		ClickOnBy_Id("submitAccount");
	}
	
	public void IsAccountAdded()
	{
		WebElement element = driver.findElement(By.xpath("//h1[text()='My account']")); 
		
		boolean ActualResult = element.isDisplayed();
		
		if (ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else 
		{
			assert false: "There are an Issue at Creating the Account"; 
		}
	}
	
	
	

}
