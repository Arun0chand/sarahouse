package apachepoi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreen {
	
	
	@Test
	
	public void setup() throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.browserstack.com/guide/action-class-in-selenium");
	driver.navigate().refresh();
	
	/*JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("window.scrollBy(0,1000)");
	WebElement element=driver.findElement(By.xpath("//a[contains(text(), 'Wikimedia ')]"));
//	js.executeScript("window.scrollBy(0,1000)");
//	js.executeScript("arguments[0].scrollIntoView();", element);
	TakesScreenshot ts=(TakesScreenshot)driver;
	byte[] byteArr=ts.getScreenshotAs(OutputType.BYTES);
	File destFile=new File("./screens/data1.jpg");
	FileOutputStream fo=new FileOutputStream(destFile);
	fo.write(byteArr);
	fo.close();
//	js.executeScript("arguments[0].scrollIntoView();", element);
//	js.executeScript("window.scrollBy(0,1000)");
//	js.executeScript("window.scrollBy(0,1000)");
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	Actions act=new Actions(driver);
	act.contextClick().build().perform();*/
	
	List<WebElement> drivers=driver.findElements(By.tagName("button"));
	int s=drivers.size();
	System.out.println(s);
	for(WebElement all:drivers) {
		
		all.getText();
		System.out.println(all);
	}
	
	
	
	
	
	

}
}
