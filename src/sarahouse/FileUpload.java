package sarahouse;

import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Toolkit;

public class FileUpload {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(cp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/maps/d/edit?hl=en&mid=1GnLo8qeQUS85iVk1Y64LrVOH46ZAyso&ll=15.854161601052223%2C82.75998700000002&z=4");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("nagaraj@active.agency");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Nagu@123");
		Thread.sleep(1000);
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		 driver.findElement(By.xpath("(//div[.='Import'])[1]")).click();
		 
		 Thread.sleep(3000);
		 
			WebElement popupFrame = driver.findElement(By.xpath("//div[@id=':33.contentEl']//iframe"));
			//iframe[@id='gr92i74sdgzw']
		
			driver.switchTo().frame(popupFrame);
			Thread.sleep(2000);
			//To click on select file button
			driver.findElement(By.xpath("//div[text()='Select a file from your device']")).click();
			
			//To close the frame 
			//driver.findElement(By.xpath("//div[@class='le-ak-db-zi']")).click();
			Thread.sleep(3000);
			//switch back to parent frame
			driver.switchTo().parentFrame();
		
			String path="D:\\F2.txt";
		 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		// js.executeScript("argument[0].click();", buttonclick);
		rt.delay(2000);
		
		  StringSelection ss=new StringSelection(path);
		  Toolkit toolKit = Toolkit.getDefaultToolkit();
		 Toolkit.getDefaultToolkit().getSystemClipboard();
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 System.out.println("File Selection =  "+ path);
//		 
		 rt.keyPress(KeyEvent.VK_CONTROL);
		 rt.keyPress(KeyEvent.VK_V);
		 rt.delay(1000);
	   
		 rt.keyRelease(KeyEvent.VK_CONTROL);
		 rt.keyRelease(KeyEvent.VK_V);
		 rt.delay(1000);
//		 
		 rt.keyPress(KeyEvent.VK_ENTER);
		 rt.keyRelease(KeyEvent.VK_ENTER);
		 rt.delay(1000);
		  	//file access
		  	Thread.sleep(1000);
		  	//virtual Key VK
		  	rt.keyPress(KeyEvent.VK_CONTROL);
		  	rt.keyPress(KeyEvent.VK_V);
		  	Thread.sleep(1000);
		  	rt.keyRelease(KeyEvent.VK_CONTROL);
		  	rt.keyRelease(KeyEvent.VK_V);
		  	Thread.sleep(1000);
		  	rt.keyPress(KeyEvent.VK_ENTER);
		  	rt.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(5000);
		driver.quit();

	}

}
