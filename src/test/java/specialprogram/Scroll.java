package specialprogram;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apachepoi.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utility;

public class Scroll {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		WebDriver driver = new ChromeDriver(options);

		
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/tooltip/");
		
		/*
		 * String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		 * driver.findElement(By.xpath("sss")).sendKeys(tab);
		 */
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://jqueryui.com/tooltip/");
		/*
		 * Rectangle
		 * element=driver.findElement(By.xpath("//h1[text()='Tooltip']")).getRect();
		 * 
		 * System.out.println(element.getX()); System.out.println(element.getY());
		 */
		
//		 System.out.println(element);

	   
	}
}

