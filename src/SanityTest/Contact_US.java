package SanityTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.Contact_US_PO;


public class Contact_US extends ConfigData {
	
	Contact_US_PO send; 
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		send = new Contact_US_PO();
		getDriver();
		ReadData();
	}
	
	
	@Test
	public void Send_Message()
	{
		send.ClickOnContactUS();
		send.Fill_SubjectHeading();
		send.Fill_EmailAddres();
		send.Fill_OrderReference();
		//send.UploadFile();
		send.Fill_Message();
		send.ClickOnSubmit();
		send.IsMessageSent();
	}

}
