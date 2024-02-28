package specialprogram;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshotUtil;
import utility.ScreenshotWebelement;
import utility.duplicate;

public class TakesScreen {
	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		
//		  TakesScreenshot ts=(TakesScreenshot)driver; File
//		  source=ts.getScreenshotAs(OutputType.FILE); File dest=new
//		  File("/home/active38/eclipse-workspace/apachepoi/screen/image3.png");
//		  FileUtils.copyFile(source, dest);
		  WebElement section=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
//		  File source2=section.getScreenshotAs(OutputType.FILE); File dest2=new
//		  File("/home/active38/eclipse-workspace/apachepoi/screen/image4.png");
//		  FileUtils.copyFile(source2, dest2);
		 
		  ScreenshotWebelement.elementScreenshot(driver,section,"Ppage");
	}

}
