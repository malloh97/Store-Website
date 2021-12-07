package PageObjectModel.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class UpdatePersonal_Information_PO extends ConfigData {
	
	
	static WebElement element;
	
	
	public void ClickOnMyPersonalInfo()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Information')]");
	}

	
	public void Fill_FirstName()
	{
		element = driver.findElement(By.id("firstname"));
		ClearData(element);
		SendKeysBy_Id("firstname", prop.getProperty("First_Name"));
	}
	
	public void Fill_LastName()
	{
		element = driver.findElement(By.id("lastname"));
		ClearData(element);
		SendKeysBy_Id("lastname", prop.getProperty("Last_Name"));
	}
	
	public void Set_email()
	{
		element = driver.findElement(By.id("email"));
		ClearData(element);
		SendKeysBy_Id("email", prop.getProperty("email"));
	}
	
	
	public void Fill_CurrentPassword()
	{
		SendKeysBy_Id("old_passwd", prop.getProperty("OldPassword"));
	}
	
	public void Fill_NewPassword()
	{
		SendKeysBy_Id("passwd", prop.getProperty("NewPassword"));
	}
	
	public void ConfirmationPassword()
	{
		SendKeysBy_Id("confirmation", prop.getProperty("NewPassword"));
	}
	
	public void SaveUpdating()
	{
		ClickOnBy_Xpath("(//button[contains(@type, 'submit')])[2]");
	}
	
	public void CheckNotification()
	{
		element = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-success')]"));
		
		boolean ActualResult = IsDisplayed(element);
		
		if (ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
	}
	
	
}