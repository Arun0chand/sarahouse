package apachepoi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	WebDriver driver;
    public static void main(String[] args) {
    	
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Perform some actions with the WebDriver
        
        // Quit the WebDriver session
        driver.quit();
        
        // The following line will not be executed successfully
        driver.get("www.google.com");
    }
}