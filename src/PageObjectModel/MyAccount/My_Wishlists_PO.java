package PageObjectModel.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class My_Wishlists_PO extends ConfigData {
	
	
	static WebElement element;
	
	/*
	 * 
	 *    Create New Wishlist
	 * 
	 */
	
	public void ClickOnNameAccount()
	{
		ClickOnBy_Xpath("//a[contains(@class,'account')]");
	}
	
	public void ClickOnMyWishlist()
	{
		ClickOnBy_Xpath("//a[contains(@title,'My wishlists')]");
	}
	
	public void Fill_WishlistName()
	{
		SendKeysBy_Id("name", prop.getProperty("WishlistName"));
	}
	
	public void Save_Wishlist()
	{
		ClickOnBy_Id("submitWishlist");
	}

	
	
	/*
	 * 
	 *    Add Product to this Wishlist
	 * 
	 */
	
	
	
	public void BackToHome()
	{
		ClickOnBy_Xpath("//img[contains(@class,'logo img-responsive')]");	
	}
	
	public void ClickOnBestSellers()
	{
		Scroll_Down();
		
		ClickOnBy_Xpath("//a[contains(@class,'blockbestsellers')]");
	}
	
	public void ClickatProduct()
	{
		ClickOnBy_Xpath("(//a[contains(@title,'Blouse')])[5]");
	}
	
	public void ClickOnMore()
	{
		ClickOnBy_Xpath("//div[contains(@class,'product-container')]");
	}
	
	public void ClickOnAddToWishlist()
	{
		ClickOnBy_Id("wishlist_button");
	}
	
	public void CloseTheAlert()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Close')]");
	}
	
	
	
	/*
	 * 
	 *    Check Of Product added to Wishlist
	 * 
	 */
	
	
	
	public void ClickOnView()
	{
		ClickOnBy_Xpath("(//a[contains(@onclick,'javascript:WishlistManage')])[2]");
	}
	
	public void IsProductAdded()
	{
		element = driver.findElement(By.id("s_title"));
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
	
	/*
	 * 
	 *     Edit at Product and Save it  
	 * 
	 */
	
	public void ClickToViewProduct()
	{
		ClickOnBy_Xpath("//*[@id=\"wishlist_41771\"]/td[5]/a");
	}
	
	public void Fill_Quantity()
	{
		SendKeysBy_Id("quantity_2_7", "3");
	}
	
	
	public void Fill_Priority()
	{
		SelectFrom_VisibleText("priority_2_7", "High");
	}
	
	public void Save_Product()
	{
		ClickOnBy_Xpath("//a[contains(@title,'Save')]");
	}
	
	
	
	/*
	 * 
	 *      Delete Wishlist
	 * 
	 */
	
	
	public void ClickOnDeleteArrow()
	{
		ClickOnBy_Xpath("//i[contains(@class,'icon-remove')]");
		Accept_Alert();
		
	}
	
	public void IsWishlistDeleted()
	{   
		element = driver.findElement(By.id("wishlist_41719"));
		boolean ActualResult = IsDisplayed(element);
		
		if (ActualResult==false)
		{
			Assert.assertFalse(ActualResult);
		}
		else
		{
			assert false: "Unexpected Error !!"; 
		}
	}
	
	
	/*
	 * 
	 *   Send Wishlist to others
	 * 
	 */
	
	public void ClickOnSendThisWishlist()
	{
		element = driver.findElement(By.id("showSendWishlist"));
		DoubleClick(element);
		
		//ClickOnBy_Id("showSendWishlist");
		
	}
	
	public void Fill_Email()
	{
		SendKeysBy_Id("email1", prop.getProperty("email"));
	}
	
	public void ClickOnSend()
	{
		ClickOnBy_Name("submitWishlist");
	}
	


}
