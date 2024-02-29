package utility;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot {
	public static void takingshot(WebDriver driver)  {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String destfilepath="Arun/screens"+timestamp+".png";
		
		try {
			FileUtils.copyFile(src, new File(destfilepath));
			System.out.println("ScreenshotCaptured"+destfilepath);
		}catch(IOException e) {
			System.err.println("Error occured"+e.getMessage());
		}
		
	}
}
