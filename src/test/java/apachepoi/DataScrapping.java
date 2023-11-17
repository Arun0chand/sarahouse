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

public class DataScrapping {
	
	@Test
	
	public void setUp() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String path="./dataxxx/data17.xlsx";
		Utility util=new Utility(path);
		
		//Write the headers in the excel file sheet
		util.setCellData("sheet1", 0, 0, "Country");
		util.setCellData("sheet1", 0, 1, "population");
		util.setCellData("sheet1", 0, 2, "% of world");
		util.setCellData("sheet1", 0, 3, "Date");
		util.setCellData("sheet1", 0, 4, "Source");
		
		WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody"));
		//Capture the rows from the table
		int totalrows=table.findElements(By.xpath("tr")).size();
		
		for(int r=1;r<=totalrows;r++) {
			String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String perOfworld=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			System.out.println(country+population+perOfworld+date+source);
			//write the data in the excel sheet
			util.setCellData("Sheet1", r, 0, country);
			util.setCellData("Sheet1", r, 1, population);
			util.setCellData("Sheet1", r, 2, perOfworld);
			util.setCellData("Sheet1", r, 3, date);
			util.setCellData("Sheet1", r, 4, source);
			
		}
		System.out.println("Webdata scrapping successfully");
		driver.close();
	}

}
