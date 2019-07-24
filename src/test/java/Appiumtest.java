
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
@SuppressWarnings("rawtypes")
public class Appiumtest {
	
	AndroidDriver driver;
	By linktext=By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input");
	By Click_button=By.cssSelector("#tsf > div:nth-child(2) > div.A7Yvie.emca > div.zGVn2e > button.Tg7LZd");
	By Click_linktext=By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div[1]/a/div[2]");
	@BeforeSuite
    public void test1_launch_package() throws IOException
    {
        String activity="com.android.browser.BrowserActivity";
    	String package_name="com.android.browser";
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	  capabilities.setCapability("deviceName","emulator-5554");
    	  capabilities.setCapability("platformName","Android");
    	  capabilities.setCapability("CapabilityType.BROWSER_NAME", "Android");
          capabilities.setCapability("appPackage", package_name);
          capabilities.setCapability("appActivity", activity);
    	  capabilities.setCapability("automationName","UiAutomator1");

    	  driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    	  driver.launchApp();
    	  System.out.println(driver.getContext());
    	  HashSet contexts = (HashSet) driver.getContextHandles();
    	  System.out.println(contexts);
    	  driver.context("WEBVIEW_com.android.browser");
    }
	@Test
	public void test2__New()
	{

		
 
		driver.findElement(linktext).sendKeys("Qainfotech.com");
		driver.findElement(Click_button).click();
		driver.findElement(Click_linktext).click();
		String title=driver.getTitle();
		System.out.println(title);
	}
	@AfterSuite
	public void close_driver()
	{
		driver.quit();
	}
	

}
