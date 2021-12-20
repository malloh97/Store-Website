package listeners;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Listener implements ITestListener {
	
	
	public static ExtentReports extent;
	public static ExtentTest Logger; 
	public static ExtentSparkReporter htmlReporter;
	
	
	
	public void onStart(ITestContext context) 
	{	
		System.out.println("Testing Is Started");
		
		extent = new ExtentReports(); 
		htmlReporter = new ExtentSparkReporter("C:\\Store Website\\TestingReport\\Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project", "Automation Scripts for My Store Website");
		extent.setSystemInfo("Automation Tool", "Selenium");
		extent.setSystemInfo("Framwork", "TestNG");
		extent.setSystemInfo("Design Pattern", "Page Object Model");
		extent.setSystemInfo("Language", "JAVA");
		extent.setSystemInfo("Tester", "Ahmad Malloh");
	}

	public void onFinish(ITestContext context)
	{
		System.out.println("Testing Is Done");
		extent.flush();
	}
	
		public void onTestStart(ITestResult result)
		{
			System.out.println("New Test Started" + result.getName());
			Logger = extent.createTest(result.getName()); 
		}
		
		public void onTestSuccess(ITestResult result)
		{
			System.out.println(result.getName() + "Test Successed");
			Logger.log(Status.PASS, "Passed"); 
		}

		public void onTestFailure(ITestResult result)
		{
			System.out.println(result.getName() + "Test Failure");
			System.out.println(result.getThrowable()); 
			Logger.log(Status.FAIL, "Failure"); 
		}

		public void onTestSkipped(ITestResult result)
		{
			System.out.println(result.getName() + "Test Skipped");
			Logger.log(Status.SKIP, "Skipped");
		}

//		public void onTestFailedButWithinSuccessPercentage(ITestResult result)
//		{
//			System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
//		}

}
