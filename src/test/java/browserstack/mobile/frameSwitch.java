package browserstack.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import junit.framework.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class frameSwitch{

	public static final String USERNAME = "sushanth4";
	public static final String AUTOMATE_KEY = "PLtucWzo37Px3zRYaXHT";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test(enabled = true)
	public void test() {
		System.out.println("Test Run");
	}

	@Test(enabled = false)
	public void testPass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11.0");
		caps.setCapability("build","AutomationDryRun_Sham1.0");
		caps.setCapability("project","Automation_POC");
		caps.setCapability("browserstack.debug",true);
		caps.setCapability("browserstack.video", "true");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://www.time.com");
		driver.quit();
		Assert.assertTrue(true);
		System.out.println("Test Run");
	}

	@Test(enabled = false)
	public void testFail() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11.0");
		caps.setCapability("build","AutomationDryRun_Sham1.0");
		caps.setCapability("project","Automation_POC");
		caps.setCapability("browserstack.debug",true);
		caps.setCapability("browserstack.video", "true");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
		 
		//Switch by frame name
		driver.switchTo().frame("iframe1");
		System.out.println(driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/div/div[1]/p[1]/em/strong")).getText());
		driver.quit();
		Assert.assertTrue(false);
		System.out.println("Test Run");
	}

	
	@Test(enabled = true)
	public void launchMobileAndroid() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "Samsung Galaxy Note 8");
		caps.setCapability("device", "Samsung Galaxy Note 8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "7.1");
		caps.setCapability("build","AutomationDryRun_Sham1.0");
		caps.setCapability("project","Automation_POC");
		caps.setCapability("browserstack.debug",true);
		caps.setCapability("browserstack.video", "true");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.time.com");
		WebElement menuButton = driver.findElement(By.xpath("/html/body/header/div[1]/a"));
		menuButton.click();
		WebElement menuItemSignIn = driver.findElement(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]")));
		
		menuItemSignIn.click();
		WebElement signInIframe = driver.findElement(By.id("signinOverlay"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signinOverlay")));

		System.out.println("signInIframe Displayed:\t" + signInIframe.isDisplayed());
		System.out.println("signInIframe Enabled:\t" + signInIframe.isEnabled());
		Thread.sleep(5000);
		WebElement elementFrame = driver.findElement(By.id("signinOverlay"));
		driver.switchTo().frame(elementFrame);
		Thread.sleep(5000);
		WebElement frameUserName = driver.findElement(By.xpath(".//*[@id='sign-in-form']/fieldset//input[@name='username']"));
		System.out.println("frameUserName Displayed:\t"+frameUserName.isDisplayed());
		System.out.println("frameUserName Enabled:\t"+frameUserName.isEnabled()); 
		frameUserName.sendKeys("username");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
}
	
	@Test(enabled = true)
	public void launchMobileApple() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11.0");
		caps.setCapability("build","AutomationDryRun_Sham1.0");
		caps.setCapability("project","Automation_POC");
		caps.setCapability("browserstack.debug",true);
		caps.setCapability("browserstack.video", "true");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.time.com");
		WebElement menuButton = driver.findElement(By.xpath("/html/body/header/div[1]/a"));
		menuButton.click();
		WebElement menuItemSignIn = driver.findElement(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]")));
		
		menuItemSignIn.click();
		WebElement signInIframe = driver.findElement(By.id("signinOverlay"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signinOverlay")));

		System.out.println("signInIframe Displayed:\t" + signInIframe.isDisplayed());
		System.out.println("signInIframe Enabled:\t" + signInIframe.isEnabled());
		
		Thread.sleep(5000);
		
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("document.domain='time.com';");
		
		WebElement elementFrame = driver.findElement(By.id("signinOverlay"));
		driver.switchTo().frame(elementFrame);
		Thread.sleep(5000);
		WebElement frameUserName = driver.findElement(By.xpath(".//*[@id='sign-in-form']/fieldset//input[@name='username']"));
		System.out.println("frameUserName Displayed:\t"+frameUserName.isDisplayed());
		System.out.println("frameUserName Enabled:\t"+frameUserName.isEnabled()); 
		frameUserName.sendKeys("username");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
}
	
	
	@Test(enabled = true)
	public void launchLocal() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/java/drivers/resource/windows/googlechrome/32bit/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.time.com");
		WebElement menuButton = driver.findElement(By.xpath("/html/body/header/div[1]/a"));
		menuButton.click();
		WebElement menuItemSignIn = driver.findElement(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav/div[1]/a[2]")));
		
		menuItemSignIn.click();
		WebElement signInIframe = driver.findElement(By.id("signinOverlay"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signinOverlay")));

		System.out.println("signInIframe Displayed:\t" + signInIframe.isDisplayed());
		System.out.println("signInIframe Enabled:\t" + signInIframe.isEnabled());
		Thread.sleep(5000);
		
		WebElement elementFrame = driver.findElement(By.id("signinOverlay"));
		driver.switchTo().frame(elementFrame);
		Thread.sleep(5000);
		WebElement frameUserName = driver.findElement(By.xpath(".//*[@id='sign-in-form']/fieldset//input[@name='username']"));
		System.out.println("frameUserName Displayed:\t"+frameUserName.isDisplayed());
		System.out.println("frameUserName Enabled:\t"+frameUserName.isEnabled()); 
		frameUserName.sendKeys("username");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test(enabled = true)
	public void launchAdbFrameLocal() throws Exception {
		System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+ "/src/main/java/drivers/resource/windows/googlechrome/32bit/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://time.com/5087163/north-south-korea-diplomacy/?testads=100");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ads1Iframe = driver.findElement(By.xpath("//iframe[contains(@name,'article_1')]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[contains(@name,'article_1')]")));

		System.out.println("Ads Frame Article 1 Displayed:\t" + ads1Iframe.isDisplayed());
		System.out.println("Ads Frame Article 1 Enabled:\t" + ads1Iframe.isEnabled());
		Thread.sleep(5000);
		
		System.out.println("iFrame Height:\t"+ads1Iframe.getAttribute("height"));
		System.out.println("iFrame Width:\t"+ads1Iframe.getAttribute("width"));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test(enabled= false)
	public void launchAdbFrameMobile() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8");
		caps.setCapability("realMobile", "true");
		//caps.setCapability("os_version", "11.0");
		caps.setCapability("build","AutomationDryRun_Sham1.0");
		caps.setCapability("project","Automation_POC");
		caps.setCapability("browserstack.debug",true);
		caps.setCapability("browserstack.video", "true");
		caps.setCapability("deviceOrientation", "landscape");
		caps.setCapability("name", "Test Case1");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://time.com/5087163/north-south-korea-diplomacy/?testads=100");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ads1Iframe = driver.findElement(By.xpath("//iframe[contains(@name,'article_1')]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[contains(@name,'article_1')]")));

		System.out.println("Ads Frame Article 1 Displayed:\t" + ads1Iframe.isDisplayed());
		System.out.println("Ads Frame Article 1 Enabled:\t" + ads1Iframe.isEnabled());
		Thread.sleep(5000);
		
		System.out.println("iFrame Height:\t"+ads1Iframe.getAttribute("height"));
		System.out.println("iFrame Width:\t"+ads1Iframe.getAttribute("width"));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
