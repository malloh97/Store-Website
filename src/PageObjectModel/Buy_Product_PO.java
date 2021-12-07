package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Configration.ConfigData;

public class Buy_Product_PO extends ConfigData {
	
	
	
	public void ClickOn_WomenCategory()
	{
		ClickOnBy_Xpath("//a[@title='Women']");
	}
	
	public void Fill_Category()
	{
		ClickOnBy_Id("layered_category_8");
	}
	
	public void Fill_Size()
	{
		ClickOnBy_Id("layered_id_attribute_group_3");
	}
	
	public void Fill_Compositions()
	{
		ClickOnBy_Id("layered_id_feature_5");
	}

	public void Fill_Styles()
	{
		ClickOnBy_Id("layered_id_feature_11");
	}
	
	public void Fill_Properties()
	{
		ClickOnBy_Id("layered_id_feature_19");
	}
	
	public void Fill_Price()
	{
		RangeSlider("//a[contains(@class, 'ui-slider-handle ui-state-default ui-corner-all')]", 20, 30);	
		
	}
	
	public void ChangeView_ToList()
	{
		ClickOnBy_Xpath("//i[contains(@class,'icon-th-list')]");
	}
	
	/*
	 *  
	 *  Add First and Second to Cart
	 * 
	 */
	
	public void ClickOnFirstProduct()
	{
		ClickOnBy_Xpath("//a[contains(@class, 'button ajax_add_to_cart_button btn btn-default')]");
		
		ClickOnBy_Xpath("//span[contains(@title, 'Continue shopping')]"); // click on Continue shopping
	}
	
	
	public void ClickOnSecondProduct()
	{
		ClickOnBy_Xpath("(//a[contains(@class, 'button ajax_add_to_cart_button btn btn-default')])[2]");
		
		ClickOnBy_Xpath("//a[contains(@title, 'Proceed to checkout')]"); // click on Proceed to checkout
	}
	
	public void Increase_Qty()
	{
		Scroll_Down();
		ClickOnBy_Id("cart_quantity_up_1_1_0_0"); // Increase Qty of first product
		
		ClickOnBy_Id("cart_quantity_up_2_7_0_0"); // Increase Qty of second product
	}
	
	public void ClickOnProceedtoCheckout()
	{
		ClickOnBy_Xpath("//a[contains(@class, 'button btn btn-default standard-checkout button-medium')]");
	}
	
	public void FillNote_OnOrder()
	{
		SendKeysBy_Name("message", prop.getProperty("Message"));
	}
	
	public void ClickOnProcessAddress()
	{
		ClickOnBy_Name("processAddress");
	}
	
	
	public void CLickOnTerms_of_Service()
	{
		ClickOnBy_Id("cgv"); //  click on I agree to the terms of service and will adhere to them unconditionally
	}
	
	public void ClickOnCheckout()
	{
		ClickOnBy_Name("processCarrier");
	}
	
	static String TotalPrice = null;
	public void ChoosePayment()
	{
		WebElement element = driver.findElement(By.id("total_price"));
		
		TotalPrice = getText(element); // get the value of total price
		
		ClickOnBy_Xpath("//a[contains(@title, 'Pay by bank wire')]");
	}
	
	public void ClickOnConfirmOrder()
	{
		ClickOnBy_Xpath("(//button[@type='submit'])[2]");
	}
	
	boolean Result;
	public void IsOrderCompleted()
	{
		ClickOnBy_Xpath("//a[contains(@class,'account')]"); // click on account
		
		ClickOnBy_Xpath("//a[contains(@title,'Orders')]"); // click to see Orders history
		
        Result = true;
		int count = getSize("//span[@class='price']");
		
		for (int i=1; i<count; i++)
		{
			String ActualPrice = driver.findElement(By.xpath("(//span[@class='price'])["+i+"]")).toString();
			if (ActualPrice.equals(TotalPrice))
			{
				Assert.assertTrue(Result);
			}
			else
			{
				assert false: "Unexpected Error !!"; 
			}
		}
	}
	
	

}
