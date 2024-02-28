package apachepoi;

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
	
	public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com");
		driver.navigate().refresh();
		
		Thread.sleep(2000);
	
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) {
            WebElement webele = links.get(i);

            try {
                String url = webele.getAttribute("href");

                    System.out.println(url);
                    URL link = new URL(url);
                    HttpURLConnection httpcon = (HttpURLConnection) link.openConnection();
                    httpcon.setRequestMethod("GET");
                    httpcon.connect();
                   
                    int responseCode = httpcon.getResponseCode();
                    
                    if (responseCode >= 400) {
                        System.out.println(i + " " + url + " : Href is a broken link");
                    } else {
                        System.out.println(i + " " + url + " ==> Href is not a broken link");
                    }
                
            } catch (MalformedURLException e) {
                System.out.println(i + ": Malformed URL exception - " + e.getMessage());
            } catch (Exception e) {
                System.out.println(i + ": Exception occurred - " + e.getMessage());
            }
        }
}
}
