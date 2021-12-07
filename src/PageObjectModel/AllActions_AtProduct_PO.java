package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class AllActions_AtProduct_PO extends ConfigData {
	
	static WebElement element;
	
	/*
	 * 
	 *   Search for a Product
	 * 
	 */
	
	public void Fill_ProductName()
	{
		SendKeysBy_Id("search_query_top", prop.getProperty("productName"));
	}

	
	public void ClickOnSearchIcon()
	{
		ClickOnBy_Name("submit_search");
	}
	
	public void ClickOnProduct()
	{
//		element = driver.findElement(By.xpath("(//a[contains(@title,'Faded Short Sleeve T-shirts')])[2]"));
//		MoveToElement(element);
		ClickOnBy_Xpath("(//a[contains(@title,'Faded Short Sleeve T-shirts')])[2]");
	}
	
	public void BackToHome()
	{
		ClickOnBy_Xpath("//img[contains(@class,'logo img-responsive')]");
	}
	
	/*
	 * 
	 *    Write a Review at the Product 
	 * 
	 */
	
	public void ClickOnWriteReview()
	{
		ClickOnBy_Xpath("//a[contains(@class,'open-comment-form')]");
	}
	
	public void Fill_Rating()
	{
		ClickOnBy_Xpath("(//a[contains(@title,'4')])[2]");
	}
	
	public void Fill_Title()
	{
		SendKeysBy_Id("comment_title", prop.getProperty("Title"));
	}
	
	public void Fill_Comment()
	{
		SendKeysBy_Id("content", prop.getProperty("Message"));
	}
	
	public void ClickOnSend()
	{
		ClickOnBy_Id("submitNewMessage");
		
		ClickOnBy_Xpath("//button[contains(@class,'button btn-default button-medium')]"); // click on OK
	}
	
	
	
	/*
	 * 
	 *    Send The Product to Friend
	 * 
	 */
	
	
	public void ClickOn_SendToFriend()
	{
		ClickOnBy_Id("send_friend_button");
	}
	
	public void Fill_FriendName()
	{
		SendKeysBy_Id("friend_name", prop.getProperty("FriendName"));
	}
	
	public void Fill_FriendEmail()
	{
		SendKeysBy_Id("friend_email", prop.getProperty("FriendEmail"));
	}
	
	public void SendEmail()
	{
		ClickOnBy_Id("sendEmail");
		
		ClickOnBy_Xpath("//input[contains(@class,'button')]"); // click on OK
	}
	
	
	
	/*
	 * 
	 *   Print the Product   
	 * 
	 */
	
	public void ClickOnPrint()
	{
		ClickOnBy_Xpath("//li[contains(@class,'print')]");
	}
	 
	
	
	/*
	 * 
	 *   Add Product to the Wishlist   
	 * 
	 */
	
	
	public void clickOn_AddProduct_ToWishlist()
	{
		ClickOnBy_Id("wishlist_button");
		
		ClickOnBy_Xpath("//a[contains(@title,'Close')]"); // close alert
	}
	
	
	/*
	 * 
	 *    Add the Product to the Cart 
	 * 
	 */
	
	
	public void IncreaseTheQuantity()
	{
		ClickOnBy_Xpath("//i[contains(@class,'icon-plus')]");
	}
	
	public void Fill_Size()
	{
		SelectFrom_VisibleText("group_1", "M");
	}
	
	public void ClickOnAddToCart()
	{
		ClickOnBy_Name("Submit");
	}
	
	public void IsProductAdded()
	{
		ClickOnBy_Xpath("//a[contains(@title,'View my shopping cart')]"); // expand My Cart
		
		boolean ActualResult = isExist("//a[contains(@title,'Faded Short Sleeve T-shirts')]");
		
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
