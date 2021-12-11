package SanityTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.CheckSocialMediaLinks_PO;

public class CheckSocialMediaLinks extends ConfigData {
	
	
	CheckSocialMediaLinks_PO Social;
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void beforeMethod(String Browser)
	{
		Social = new CheckSocialMediaLinks_PO();
		getDriver(Browser);
		ReadData();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		teardown();
	}
	
	@Test(priority=1, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void CheckFaceBookLink()
	{
		Social.ScrollInto_SocialMediaLinks();
		Social.ClickOnFaceBookLink();
		Social.IsFaceBookOpened();
	}
	
	@Test(priority=2, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void CheckTwitterLink()
	{
		Social.ScrollInto_SocialMediaLinks();
		Social.ClickOnTwitterLink();
		Social.IsTwitterOpened();
	}
	
	@Test(priority=3, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void CheckYoutubeLink()
	{
		Social.ScrollInto_SocialMediaLinks();
		Social.ClickOnYoutubeLink();
		Social.IsYoutubeOpened();
	}
	
	@Test(priority=4, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void CheckGoogleLink()
	{
		Social.ScrollInto_SocialMediaLinks();
		Social.ClickOnGoogleLink();
		Social.IsGoogleOpened();
	}

}
