package sarahouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;





public class AnilTest {
WebDriver driver;
	
	
   @Test
	public void setupTest() throws InterruptedException
	{
	   System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(cp);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	
	
	
		
//		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("arun");
		Thread.sleep(2000);
//		driver.findElement(By.name("password")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sendkeys");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
	}

	
	@Test()
	public void Testcase2() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		driver.quit();
       
	}

}