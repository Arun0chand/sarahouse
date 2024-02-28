package popusall;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authpopup {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//		driver.get("https://www.redbus.in/");
		
		 boolean verify = driver.findElement(By.xpath("//div[@class='example']/p")).isDisplayed();
		System.out.println(verify);
	}
}
