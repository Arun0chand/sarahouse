package apachepoi;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data1 {
	
	@Test
	
	public void setUp() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/wiki/Table_(information)");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		String path="./dataxxx/data18.xlsx";
		Utility util=new Utility(path);
		
		//Write the headers in the excel file sheet
		util.setCellData("sheet1", 0, 0, "FirstName");
		util.setCellData("sheet1", 0, 1, "LastName");
		util.setCellData("sheet1", 0, 2, "Age");
		
		
		WebElement table=driver.findElement(By.xpath("(//table[@class='wikitable'])[1]//tbody"));
		//Capture the rows from the table
		int totalrows=table.findElements(By.xpath("tr")).size();
		
		for(int r=1;r<=totalrows;r++) {
			String FirstName=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String LastName=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String Age=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			
			//write the data in the excel sheet
			util.setCellData("Sheet1", r, 0, FirstName);
			util.setCellData("Sheet1", r, 1, LastName);
			util.setCellData("Sheet1", r, 2, Age);
			
			
		}
		System.out.println("Webdata scrapping successfully");
		driver.close();
	}

}

