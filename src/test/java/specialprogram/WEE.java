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

import io.github.bonigarcia.wdm.WebDriverManager;

public class WEE {
	
	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		/*for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));*/
			int brokenLinks=0;
			int validLinks=0;
		for(WebElement alllinks:links) {
			
			String url=alllinks.getAttribute("href");
			if(url==null|| url.isEmpty()) {
				System.out.println("Url is empty");
				continue;
			}
			
			try {
				URL link=new URL(url);
				
				HttpURLConnection httpconn=(HttpURLConnection)link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode()+" is"+url+" is a broken link");
					brokenLinks++;
				}else {
					System.out.println(httpconn.getResponseCode()+" is"+url+" is a valid link");
					validLinks++;
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("The broken link count is "+brokenLinks);
		System.out.println("The broken link count is "+validLinks);
		driver.quit();
	}

}
