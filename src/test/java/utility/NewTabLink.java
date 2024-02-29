package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabLink {


	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		//		String str=Keys.chord(Keys.CONTROL,Keys.RETURN);

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("/home/active38/eclipse-workspace/apachepoi/Screen/type1.png");
		FileUtils.copyFile(src, dest);
		driver.findElement(By.xpath("(//a[text()='Tech News'])[1]")).click();
		//		driver.switchTo().newWindow(WindowType.WINDOW);
		//		driver.get("http://www.deadlinkcity.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='हिन्दी']")).click();
		File src1=ts.getScreenshotAs(OutputType.FILE);
		File dest1=new File("/home/active38/eclipse-workspace/apachepoi/Screen/type2.png");
		FileUtils.copyFile(src1, dest1);
		
		
		 Alert alert=driver.switchTo().alert();
		 alert.dismiss();
		 alert.dismiss();
		 
	}
}
