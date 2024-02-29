package utility;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class DynamicScreenshotExample {
    public static void main(String[] args) {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to a web page
        driver.get("https://www.example.com");

        // Take a screenshot with a dynamic filename
        takeScreenshot(driver);

        // Close the browser
        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver) {
        // Convert the WebDriver instance to TakesScreenshot
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        // Generate a timestamp for the filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Specify the destination file path with a dynamic filename
        String destinationFilePath = "path/to/screenshots/screenshot_" + timestamp + ".png";

        try {
            // Copy the file to the destination path
            FileUtils.copyFile(screenshotFile, new File(destinationFilePath));
            System.out.println("Screenshot captured: " + destinationFilePath);
        } catch (IOException e) {
            System.err.println("Error while taking screenshot: " + e.getMessage());
        }
    }
}


