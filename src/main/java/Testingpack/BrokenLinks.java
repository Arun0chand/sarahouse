package Testingpack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {


	public static void main(String[] args) throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement>all=driver.findElements(By.tagName("a"));
		System.out.println(all.size());
		int Brokenlinks=0;
		int Validlinks=0;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		for(WebElement alllinks:all) {
			String url=alllinks.getAttribute("href");
			
			if(url==null||url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			URL link=new URL(url);
			try {
				HttpURLConnection httpcon=(HttpURLConnection)link.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400) {
					System.out.println(httpcon.getResponseCode()+httpcon.getRequestMethod()+" "+url+" "+"Link is broken");
					Brokenlinks++;
				}else {
					System.out.println(httpcon.getResponseCode()+httpcon.getRequestMethod()+" "+url+" "+" Link is Valid");
					Validlinks++;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Broken links count "+Brokenlinks);
		System.out.println("Valid link count "+Validlinks);

	}
}
