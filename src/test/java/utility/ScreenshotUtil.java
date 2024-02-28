package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
	
	public static void takescreenShot(WebDriver driver,String screenshotName) {
	
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // Get the screenshot file
        File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Specify the destination directory (replace with your desired directory)
        String destinationDirectory = "screenshots/";

        // Create the directory if it doesn't exist
        File directory = new File(destinationDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a timestamp for the screenshot file
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Create the final screenshot file with a unique name
        File destfile = new File(destinationDirectory + screenshotName + "_" + timestamp + ".png");

        try {
            // Copy the screenshot file to the destination
            FileHandler.copy(sourcefile, destfile);
            System.out.println("Screenshot captured: " + destfile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Unable to capture screenshot: " + e.getMessage());
        }
    }
	}

