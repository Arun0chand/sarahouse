package specialprograms;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;




public class SS {
 public static void main(String[] args) throws InterruptedException {
	
	 
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,2000)");
	driver.switchTo().frame("frm3");
//	driver.findElement(By.xpath("(//img[@alt='HYR'])")).click();
	
	
	WebElement targetscroll=driver.findElement(By.xpath("//html[@dir='ltr']"));
	js.executeScript("window.scrollBy(0,1000)");
	driver.switchTo().frame("frm2");
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("sugar");
	driver.switchTo().parentFrame();
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("arjun");
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("done success");
}
}
