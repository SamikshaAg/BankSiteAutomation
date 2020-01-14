package newPackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyClass {
	static String driverPath;
	static WebDriver driver;
	
	
	public static void setup() {
		driverPath = Util.CHROME_BINARY_PATH;
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}
	
	public static void main(String args[]) {
		setup();
		driver.get(Util.BASE_URL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement userId = driver.findElement(By.name("uid"));
		userId.sendKeys("mngr241739");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("AvasAme");
		
		password.submit();
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}

}
