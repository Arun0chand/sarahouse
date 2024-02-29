package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {
	static WebDriver driver;
	
	
	public static WebElement explicitWait(WebDriver driver,By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    return driver.findElement(locator);
	}
	
	public static void selectDropdown(WebElement element,String value) {
		driver.navigate().forward();
		Select drp=new Select(element);
		List<WebElement>alloptions=drp.getOptions();
		for(WebElement options:alloptions) {
			if(options.getText().equals(value)) {
				
				options.click();
				break;
			}
			
		}
	}
}

