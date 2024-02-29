package specialprograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class t {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parentwindow=driver.getWindowHandle();
		/*
		 * System.out.println(parentwindow);
		 * System.out.println("Parent window id and title"+driver.getTitle());
		 */
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		Set<String>allwindows=driver.getWindowHandles();
		System.out.println(allwindows.size());
		for(String all:allwindows) {
			
		if(!all.equals(parentwindow)) {	
			
	 System.out.println(driver.switchTo().window(all).getTitle());
	    if(driver.getTitle().equals("Basic Controls - H Y R Tutorials")){
	    	driver.manage().window().maximize();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("arun");
	    	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("chand");
//	    	driver.close();
	    	
	    	
	    }
				
			
		}

	}
		driver.switchTo().window(parentwindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='AutomationTesting'])[1]")).click();
		Thread.sleep(2000);
//		driver.quit();
}
}