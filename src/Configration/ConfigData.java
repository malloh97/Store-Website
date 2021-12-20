package Configration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuiteListener;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigData implements ISuiteListener {
	
	protected static WebDriver driver; 
	static File file;
	static FileInputStream fileInput; 
	protected static Properties prop; 
	
	@Parameters("Browser")
	@Test
	public static void getDriver(String Browser)
	{
		if (Browser.equalsIgnoreCase("chrome"))
		{
			
		    WebDriverManager.chromedriver().setup();
		
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito"); 
		    driver  = new ChromeDriver(options); 
		    
		    
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.get("http://automationpractice.com/index.php");
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
	public void ClickOnBy_Id(String Id)
	{
		WebElement element = driver.findElement(By.id(Id)); 
		element.click();
	}
	
	public void SendKeysBy_Id(String Id, String Data)
	{
		WebElement element = driver.findElement(By.id(Id)); 
		element.sendKeys(Data);
	}
	
	public void ClickOnBy_Name(String Name)
	{
		WebElement element = driver.findElement(By.name(Name)); 
		element.click();
	}
	
	public void SendKeysBy_Name(String Name, String Data)
	{
		WebElement element = driver.findElement(By.name(Name)); 
		element.sendKeys(Data);
	}
	
	public void ClickOnBy_LinkText(String Link)
	{
		WebElement element = driver.findElement(By.linkText(Link)); 
		element.click();
	}
	
	public void SendKeysBy_LinkText(String LinkText, String Data)
	{
		WebElement element = driver.findElement(By.linkText(LinkText)); 
		element.sendKeys(Data);
	}
	
	public void ClickOnBy_Xpath(String Xpath)
	{
		WebElement element = driver.findElement(By.xpath(Xpath)); 
		element.click();
	}
	
	public void SendKeysBy_Xpath(String Xpath, String Data)
	{
		WebElement element = driver.findElement(By.xpath(Xpath)); 
		element.sendKeys(Data);
	}
	
	
	public void Back()
	{
		driver.navigate().back();
	}
	
	@SuppressWarnings("deprecation")
	public void visibilityOfElementLocated(String Id)
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
	}
	
	@SuppressWarnings("deprecation")
	public void visibilityOfElementLocated_ByXpath(String Xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	
	
	/*
	 * Configuration for Properties file
	 * 
	 */
	
	public void ReadData()
	{
	
	 file = new File("C:\\Store Website\\src\\Data\\SensitiveData.properties");
	 fileInput = null;
	
		try
		{
			fileInput = new FileInputStream(file);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
        prop = new Properties();
		
		try 
		{
			prop.load(fileInput);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}
	
	public void SelectFrom_VisibleText(String id, String data)
	{
		WebElement element = driver.findElement(By.id(id)); 
		Select drop = new Select(element);
		
		drop.selectByVisibleText(data);
		
	}
	
	public void SelectFrom_ByIndex(String id, int data)
	{
		WebElement element = driver.findElement(By.id(id)); 
		Select drop = new Select(element);
		
		drop.selectByIndex(data);
	}
	
	public void Scroll_IntoView(WebElement element)
	{
		//WebElement element = driver.findElement(By.id(id));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public boolean IsDisplayed(WebElement element)
	{
		boolean check = element.isDisplayed();
		
		return check; 
	}
	
	public void Scroll_Up()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	public void Scroll_Down()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	public void RangeSlider(String element, int startValue, int endValue)
	{
        WebElement Slider = driver.findElement(By.xpath(element));
		
		Actions action = new Actions(driver); 
		action.dragAndDropBy(Slider, startValue, endValue).perform(); 
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public int getSize(String xpath)
	{
		return driver.findElements(By.xpath(xpath)).size();
	}
	
	public void ClearData(WebElement element)
	{
		element.clear();
	}
	
	public boolean IsEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	
	public boolean isExist(String xpath)
	{

		WebElement element = null;

		try {
			element = driver.findElement(By.xpath(xpath));
		} catch (Exception oe) {

			try {
				element = driver.findElement(By.xpath(xpath));

			} catch (Exception e) {

				return false;
			}
		}
		return true;
	}

	public void MoveToElement(WebElement element)
	{
		element = null;
		
		Actions action = new Actions(driver);
		action.moveToElement(element).pause(100).build().perform();
	}
	
	
	public void Accept_Alert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void DoubleClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}
	
	public void SwitchToNewWindow()
	{
		Set <String> IDs = driver.getWindowHandles();
		Iterator <String> it = IDs.iterator();
		
		it.next();
		String Child = it.next();
		
		driver.switchTo().window(Child);
	}
	
	/*
	 * 
	 *    Configuration for Extant Report 
	 * 
	 */
	
	
	
	
	
	
}
