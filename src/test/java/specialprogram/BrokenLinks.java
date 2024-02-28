package specialprogram;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

@Test
public static void setUp() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> allinks=driver.findElements(By.tagName("a"));

		//		System.out.println(allinks.size());
		int validlinks=0;
		int brokenLinks=0;
		for(WebElement all:allinks) {
			String url=all.getAttribute("href");

			if(url==null || url.isEmpty()) {
				System.out.println("Url is empty");
				continue;
			}
			URL link=new URL(url);
			try {
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode()+url+" is"+" is a Brokenlink");
					brokenLinks++;
				}else {
					System.out.println(httpconn.getResponseCode()+url+" is"+" is a Valid link");
					validlinks++;
				}
			} catch (Exception e) {
				
				
			}
		}
		System.out.println("Broken links count"+brokenLinks);
		System.out.println("Broken links count"+validlinks);
		driver.quit();



	}

}
