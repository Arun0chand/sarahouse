package specialprogram;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameMultiuple {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		WebDriver driver = new ChromeDriver(options);

		
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Set<String>window=driver.getWindowHandles();
		System.out.println(window);
		js.executeScript("window.scrollBy(0,2300)");
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		WebElement ele=driver.findElement(By.id("frm3"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Thread.sleep(2000);
		
		Select drp=new Select(driver.findElement(By.xpath("//select[@id='course']")));
		drp.selectByValue("Eclipse");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello2");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello3");
		
		
		

	}

}
