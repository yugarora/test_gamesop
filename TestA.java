package roughwork;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestA{

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://pro.gamezop.com/welcome");
			
			driver.switchTo().frame("iframe_gzp");
			WebElement mobileNo;
			WebDriverWait wait=new WebDriverWait(driver, 20);
			mobileNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='f1pik3ee']//input[@id='mobile-number']")));
			mobileNo.sendKeys("9991226688");
			
			WebElement register=driver.findElement(By.xpath("//div[@id='login-continue']"));
			register.click();
			
			//ManuallyEnteredOtp
			//login
			
		   	WebElement leftUpperTabBtn;
		     leftUpperTabBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='hamburgeImg']")));
			 leftUpperTabBtn.click();
			
			//img[@id='hamburgeImg']
			//img[@src='https://static.gamezop.com/peach/assets/img/hamburger-2.png']
		}
	}