package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnchorTags {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		
		List<WebElement>  alltags=driver.findElements(By.tagName("a"));
		try {
		System.out.println(alltags.size());
		for(WebElement all:alltags) {
			
			System.out.println(all.getText()+"==="+all.getAttribute("href"));
			
		}

	}
		catch(StaleElementReferenceException e) {
          System.out.println("e");
}
	}
}
