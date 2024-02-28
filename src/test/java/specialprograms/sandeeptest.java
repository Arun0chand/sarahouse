package specialprograms;

import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class sandeeptest {

	public WebDriver driver;

	@Test
	public void test01() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

		//		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@name='aswift_1'])[1]")));
		Thread.sleep(1000);

		for(int i=1; i<=3; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,750)");
			Thread.sleep(1000);
		}
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		selectDropdown(ele,"-- Core Java");
	}

public static void selectDropdown(WebElement element,String value) {
		
	Select drp=new Select(element);
	List<WebElement>alloptions=drp.getOptions();
	for(WebElement options:alloptions) {
		if(options.getText().equals(value)) {
			
			options.click();
			break;
		}
		
	}

	}

	//		Select sel = new Select(driver.findElement(By.xpath("(//select[@id='selectnav1'])[8]")));
	//		sel.selectByVisibleText("- XPath Practice");
	//		Thread.sleep(1000);
	//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
	//		js1.executeScript("window.scrollBy(0,400");
	
      
	//		driver.quit();

}