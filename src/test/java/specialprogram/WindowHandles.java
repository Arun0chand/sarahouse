package specialprogram;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
	
	
	
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

			//Single window
			//		String parentWindowHandle = driver.getWindowHandle();
			//		System.out.println("Parent window handle - "+parentWindowHandle + driver.getTitle());
			//		driver.findElement(By.id("newWindowBtn")).click();
			//		Set<String> windowHandles = driver.getWindowHandles();
			//		for (String windowHandle : windowHandles) {
			//			if(!windowHandle.equals(parentWindowHandle)) {
			//				driver.switchTo().window(windowHandle);
			//				driver.manage().window().maximize();
			//				driver.findElement(By.id("firstName")).sendKeys("Yadagiri");
			//				Thread.sleep(3000);
			//				driver.close();
			//				Thread.sleep(2000);
			//			}
			//		}
			//		
			//		driver.switchTo().window(parentWindowHandle);
			//		driver.findElement(By.id("name")).sendKeys("HYR TUtorials");

			// Single Tab
			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent window handle - "+parentWindowHandle + driver.getTitle());
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String windowHandle : windowHandles) {
				if(!windowHandle.equals(parentWindowHandle)) {
					
					System.out.println(driver.switchTo().window(windowHandle).getTitle());
					if(driver.getTitle().equals("Basic Controls - H Y R Tutorials")) {
						driver.manage().window().maximize();
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0,800)");
						driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("done perfectly");
						Thread.sleep(4000);
//						driver.close();
					}else if(driver.getTitle().equals("XPath Practice - H Y R Tutorials")) {
						driver.manage().window().maximize();
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0,800)");
						driver.findElement(By.xpath("//input[@maxlength='10' and @name='name']")).sendKeys("done  super perfectly");
						Thread.sleep(4000);
//						driver.close();
					}
					
				}
			}

			driver.switchTo().window(parentWindowHandle);
			driver.findElement(By.id("name")).sendKeys("HYR TUtorials");

			Thread.sleep(3000);
//			driver.quit();
		}
	
		}
		
