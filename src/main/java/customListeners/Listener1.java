package customListeners;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.Baseclass;

public class Listener1  implements ITestListener {
	//public WebDriver driver;
	
Baseclass b=new Baseclass();


	
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started successfully");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is completed successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		System.out.println("test case is going to start");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("test case is executed");
		
	}

}	
