package specialprogram;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WW {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		WebDriver driver = new ChromeDriver(options);

		
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String parentWindowHandle = driver.getWindowHandle();
				System.out.println("Parent window handle - "+parentWindowHandle + driver.getTitle());
				driver.findElement(By.id("newTabBtn")).click();
				Set<String> windowHandles = driver.getWindowHandles();
				for (String windowHandle : windowHandles) {
					if(!windowHandle.equals(parentWindowHandle)) {
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
						driver.findElement(By.xpath("//button[@id='alertBox']")).click();
						driver.switchTo().alert().accept();
						Thread.sleep(3000);
						driver.close();
						Thread.sleep(2000);
					}
				}
//				WebElement adPopup = driver.findElement(By.id("ad_position_box"));
//				adPopup.clear(); // or adPopup.close(), adPopup.sendKeys(Keys.ESCAPE), etc.



				driver.switchTo().window(parentWindowHandle);
				driver.findElement(By.id("name")).sendKeys("HYR TUtorials");
		Thread.sleep(3000);
		driver.quit();
}
}











