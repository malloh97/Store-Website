package SanityTest.MyAccount;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configration.ConfigData;
import PageObjectModel.MyAccount.Add_Update_DeleteAddress_PO;
import PageObjectModel.MyAccount.My_Wishlists_PO;

public class My_Wishlists extends ConfigData {
	
	Add_Update_DeleteAddress_PO Login;
	My_Wishlists_PO wish;
	
	@BeforeTest
	public void beforeTest()
	{
		getDriver();
	}
	
//	@AfterTest
//	public void afterTest()
//	{
//		teardown();
//	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		Login = new Add_Update_DeleteAddress_PO();
		wish = new My_Wishlists_PO();
		ReadData();
	}
	
	@Test(priority=1)
	public void Login()
	{
		Login.ClickOnSignin();
		Login.Fill_Email();
		Login.Fill_Password();
		Login.ClickOnSigninButton();
	}
	
	@Test(priority=2, dependsOnMethods= {"Login"})
	public void Create_Wishlist()
	{
		wish.ClickOnNameAccount();
		wish.ClickOnMyWishlist();
		wish.Fill_WishlistName();
		wish.Save_Wishlist();
	}
	
	@Test(priority=3,dependsOnMethods= {"Create_Wishlist"})
	public void AddProduct_toWishlist()
	{
		wish.BackToHome();
		wish.ClickOnBestSellers();
		Scroll_Down();
		wish.ClickatProduct();
		wish.ClickOnAddToWishlist();
		wish.CloseTheAlert();
		
		// check if the product added
		
		wish.ClickOnNameAccount();
		wish.ClickOnMyWishlist();
		wish.ClickOnView();
		wish.IsProductAdded();
	}
	
	
	@Test(priority=4,dependsOnMethods= {"Create_Wishlist"})
	public void SendWithlist_toFriend()
	{
		wish.ClickOnSendThisWishlist();
		wish.Fill_Email();
		wish.ClickOnSend();
	}
	
	@Test(priority=5,dependsOnMethods= {"AddProduct_toWishlist"})
	public void EditProduct_atWishlist()
	{
		wish.ClickToViewProduct();
		Scroll_Down();
		wish.Fill_Quantity();
		wish.Fill_Priority();
		wish.Save_Product();
	}
	
	@Test(priority=6,dependsOnMethods= {"Create_Wishlist"}, enabled=false)
	public void Delete_Wishlist()
	{
		wish.ClickOnDeleteArrow();
		wish.IsWishlistDeleted();
	}
}