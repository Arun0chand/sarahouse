package apachepoi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BB {
    public static void main(String[] args) throws IOException {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the website containing the links
        driver.get("https://www.browserstack.com/guide/findelement-in-selenium");

        // Find all links on the page
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(int i=0;i<links.size();i++) {
        	WebElement ele=links.get(i);
        	try {
        	String url=ele.getAttribute("href");
        	System.out.println(url);
        	
        	URL link=new URL(url);
        	HttpURLConnection httpcon=(HttpURLConnection) link.openConnection();
        	
        	httpcon.connect();
        	int responsecode=httpcon.getResponseCode();
        	if(responsecode>=400) {
        		
        		System.out.println(i+" "+url+" : Href is broken: code ->" + responsecode );
        	}else {
        		System.out.println(i+" "+url+" : Href is not broken");
        	}
        	
        }catch(MalformedURLException e) {
        	System.out.println(i+" MalformedURLException "+e.getMessage());
        }catch(Exception e) {
        	System.out.println(i+" Exception occured"+e.getMessage());
        }
    
    		 
    	 }
    }
}

