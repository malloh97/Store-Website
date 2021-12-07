package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class AddEmail_forNewsletter_PO extends ConfigData {
	
	
	
	public void ScrollToEmailField()
	{
		WebElement element = driver.findElement(By.id("newsletter_block_left"));
		Scroll_IntoView(element);
	}
	
	public void Fill_Email()
	{
		SendKeysBy_Id("newsletter-input", prop.getProperty("email"));
	}
	
	public void ClickOnSubmitArrow()
	{
		ClickOnBy_Name("submitNewsletter");
	}
	
	public void CheckTheNotification()
	{
		WebElement element = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-success')]"));
		
		boolean ActualResult = IsDisplayed(element);
		
		if(ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
	}
	
	public void CheckExistingEmail_Notification()
	{
		WebElement element = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-danger')]"));
		
		boolean ActualResult = IsDisplayed(element); 
		
		if(ActualResult)
		{
			Assert.assertTrue(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
		
	}


}
