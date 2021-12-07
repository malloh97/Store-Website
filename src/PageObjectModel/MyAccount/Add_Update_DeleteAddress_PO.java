package PageObjectModel.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class Add_Update_DeleteAddress_PO extends ConfigData {
	
	
	/*
	 * 
	 *   Login to My Account 
	 * 
	 */
	
	WebElement element; 
	
	
	public void ClickOnSignin()
	{
         ClickOnBy_Xpath("//a[contains(@class,'login')]");
	}
	
	public void Fill_Email()
	{
		SendKeysBy_Id("email", prop.getProperty("email"));
	}
	
	public void Fill_Password()
	{
		SendKeysBy_Id("passwd", prop.getProperty("Password"));
	}
	
	public void ClickOnSigninButton()
	{
		ClickOnBy_Id("SubmitLogin");
	}
	
	/*
	 * 
	 *    Add New Address
	 * 
	 */
	
	public void Open_MyAddress()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Addresses')]");
	}
	
	public void ClickOnAddNewAddress()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Add an address')]");
	}
	
	public void ClickOnSave()
	{
		ClickOnBy_Id("submitAddress");
	}
	
	public void IsNewAddressAdded()
	{
		WebElement elemet = driver.findElement(By.xpath("(//h3[contains(@class, 'page-subheading')])[2]")); 
		
		boolean ActualResult = IsDisplayed(elemet);
		if (ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
	}
	
	/*
	 * 
	 *    Update Address
	 * 
	 */
	
	public void ClickOnUpdate()
	{
		ClickOnBy_Xpath("(//a[contains(@title,'Update')])[2]");
	}
	
	public void Update_City()
	{
		element = driver.findElement(By.id("city"));
		ClearData(element);
		SendKeysBy_Id("city", prop.getProperty("updateCity"));
	}
	
	public void Update_HomePhoneNumber()
	{
		element = driver.findElement(By.id("phone"));
		ClearData(element);
		SendKeysBy_Id("phone", prop.getProperty("updateHomePhone"));
	}
	
	public void Update_ZipCode()
	{
		element = driver.findElement(By.id("postcode"));
		ClearData(element);
		SendKeysBy_Id("postcode", prop.getProperty("updateZipCode"));
	}
	
	/*
	 * 
	 *   Delete Address 
	 * 
	 */
	
	public void ClickOnDelete()
	{
		ClickOnBy_Xpath("(//a[contains(@title,'Delete')])[2]");
	}
	
	public void ConfirmDeleteAddress()
	{
		driver.switchTo().alert().accept();
	}
	
	public void IsAddressDeleted()
	{
		Scroll_Down();
		boolean ActualResult = isExist("(//h3[contains(@class, 'page-subheading')])[2]");
		
		if (ActualResult==false)
		{
			Assert.assertFalse(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
	}
	
}
	
	
	
	