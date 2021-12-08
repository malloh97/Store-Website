package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class CheckSocialMediaLinks_PO extends ConfigData {
	
	String ExpetedURL, ActualURL;
	
	public void ScrollInto_SocialMediaLinks()
	{
		WebElement element = driver.findElement(By.id("social_block"));
		Scroll_IntoView(element);
	}
	

	/*
	 * 
	 *   Check FaceBook Link
	 * 
	 */
	
	public void ClickOnFaceBookLink()
	{
		ClickOnBy_Xpath("//li[contains(@class,'facebook')]");
	}
	
	public void IsFaceBookOpened()
	{
		ExpetedURL = "https://web.facebook.com/groups/525066904174158/?_rdc=1&_rdr";
		
		SwitchToNewWindow();
		
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpetedURL);
	}
	
	
	/*
	 * 
	 *   Check Twitter Link
	 * 
	 */
	
	public void ClickOnTwitterLink()
	{
		ClickOnBy_Xpath("//li[contains(@class,'twitter')]");
	}
	
	public void IsTwitterOpened()
	{
		ExpetedURL = "https://twitter.com/seleniumfrmwrk";
		
		SwitchToNewWindow();
		
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpetedURL);
	}
	
	
	/*
	 * 
	 *   Check Youtube Link 
	 * 
	 */
	
	public void ClickOnYoutubeLink()
	{
		ClickOnBy_Xpath("//li[contains(@class,'youtube')]");
	}
	
	public void IsYoutubeOpened()
	{
		ExpetedURL = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
		
		SwitchToNewWindow();
		
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpetedURL);
	}
	
	
	/*
	 * 
	 *   Check Google Link 
	 * 
	 */
	
	
	public void ClickOnGoogleLink()
	{
		ClickOnBy_Xpath("//li[contains(@class,'google-plus')]");
	}
	
	public void IsGoogleOpened()
	{
		ExpetedURL = "https://plus.google.com/111979135243110831526/posts";
		
		SwitchToNewWindow();
		
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpetedURL);
	}
	
}
