package apachepoi;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllAnchorTags {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Set up WebDriver (in this case, ChromeDriver)
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://v3opend.tech-active.com/admin/settings/advertiser/basic");
        driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("admin@opend.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("1234");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.navigate().refresh();
    }

    @Test
    public void testAllLinks() {
    	
    		
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");        // Find all anchor tags on the page
      List<WebElement> links = driver.findElements(By.tagName("a"));

        // Loop through each link and check if it's working
        for (WebElement link : links) {
            // Get the href attribute of the link
            String href = link.getAttribute("href");

            // Check if the href is not empty and the link is accessible
            if (href != null && !href.isEmpty()) {
                driver.navigate().to(href);

                // Verify if the page is loaded successfully
                if (driver.getTitle().contains("404") || driver.getTitle().contains("Error")) {
                    System.out.println("Broken link: " + href);
                }
            }
        }
    }
    	
    

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
