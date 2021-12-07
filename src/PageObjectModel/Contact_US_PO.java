package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class Contact_US_PO extends ConfigData {
	
	public void ClickOnContactUS()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Contact Us')]");
	}
	
	public void Fill_SubjectHeading()
	{
		SelectFrom_VisibleText("id_contact", prop.getProperty("Subject_Heading"));
	}
	
	public void Fill_EmailAddres()
	{
		SendKeysBy_Id("email", prop.getProperty("email"));
	}

	public void Fill_OrderReference()
	{
		SendKeysBy_Id("id_order", prop.getProperty("OrderReference"));
	}
	
	public void UploadFile()
	{
		SendKeysBy_Id("fileUpload", prop.getProperty("Path"));
	}
	
	public void Fill_Message()
	{
		SendKeysBy_Id("message", prop.getProperty("Message"));
	}
	
	public void ClickOnSubmit()
	{
		ClickOnBy_Id("submitMessage");
	}
	
	public void IsMessageSent()
	{
		WebElement element = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-success')]"));
		
		boolean ActualResult = element.isDisplayed();
		
		if (ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else
		{
			assert false: "There is an Issue when sending your Message !!"; 
		}
	}
	
	

}
