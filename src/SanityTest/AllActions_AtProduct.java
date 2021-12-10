package SanityTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.AllActions_AtProduct_PO;
import PageObjectModel.MyAccount.Add_Update_DeleteAddress_PO;

public class AllActions_AtProduct extends ConfigData {
	
	AllActions_AtProduct_PO Product;
	Add_Update_DeleteAddress_PO Login; 
	
	@BeforeTest
	public void beforeTest()
	{
		getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		Product = new AllActions_AtProduct_PO();
		Login = new Add_Update_DeleteAddress_PO();
		ReadData();
	}
	
	@AfterTest
	public void afterTest()
	{
		teardown();
	}
	
	@Test(priority=1, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Login()
	{
		Login.ClickOnSignin();
		Login.Fill_Email();
		Login.Fill_Password();
		Login.ClickOnSigninButton();
		Product.BackToHome();
	}
	
	@Test(priority=2, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void SearchForProduct()
	{
		Product.Fill_ProductName();
		Product.ClickOnSearchIcon();
		Scroll_Down();
		Scroll_Down();
		Product.ClickOnProduct();
	}
	
	@Test(priority=3, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void WriteReviewOnProduct()
	{
		Product.ClickOnWriteReview();
		Product.Fill_Title();
		Product.Fill_Comment();
		Product.ClickOnSend();
	}
	
	@Test(priority=4, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void SendProductToFriend()
	{
		Product.ClickOn_SendToFriend();
		Product.Fill_FriendName();
		Product.Fill_FriendEmail();
		Product.SendEmail();
		
	}
	
	@Test(priority=5, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void AddProductToWishlist()
	{
		Product.clickOn_AddProduct_ToWishlist();
	}
	
	@Test(priority=6, dependsOnMethods= {"Login"}, retryAnalyzer = listeners.RetryAnalyzer.class)
	public void AddProductToCart()
	{
		Product.IncreaseTheQuantity();
		Product.Fill_Size();
		Product.ClickOnAddToCart();
		Product.IsProductAdded();
	}


}
