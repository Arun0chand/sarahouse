package sarahouse;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver./chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.manage().window().maximize();
	}
//	******************************************************************************************
	@Test(dataProvider="LoginData")
	
	public void loginTest(String user,String pwd,String exp) {
		driver.get("https://campaignsopend.tech-active.com/#/advertiser_login");
		WebElement txtUsername=driver.findElement(By.id("email_id"));
		txtUsername.clear();
		txtUsername.sendKeys(user);
		WebElement txtPassword=driver.findElement(By.id("password"));
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String expectedTitle="https://campaignsopend.tech-active.com/#/advertiser_login";
		String actualTitle=driver.getTitle();
		if (exp.equals("valid")) {
			if (expectedTitle.equals(actualTitle)) {
				driver.findElement(By.xpath("logout")).click();
				Assert.assertEquals(true, null);
			}
			else
			{
				Assert.assertEquals(false, null);
			}
		}
			else if (exp.equals("Invalid"))
			{
			if(expectedTitle.equals(actualTitle))
			{
				driver.findElement(By.xpath("logout")).click();
				Assert.assertEquals(false, null);
			}
			else
			{
				Assert.assertEquals(true, null);
				
			}
			}
	}
//	******************************************************************************************************
	@DataProvider(name="LoginData")
	public String[][] get() throws IOException {
		String path=".\\datafiles\\Loginvalid.xlsx";
		UtilityFile file=new UtilityFile(path);
		
		int totalRows=file.getRowCount("Sheet1");
		int totalCols=file.getCellCount("Sheet1", 1);
		
		String logindata [][]=new String[totalRows][totalCols];
		for(int i=0;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				logindata[i-1][j]=file.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
				
			}
			
		
	
				
				
				
			
		
		
		
	}
	
	
	
	
		 
		
	
	
	

