package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class duplicate {
	
	public static void takeScreenshot(WebDriver driver, WebElement element, String screenshotName) {
        // Cast WebDriver to TakesScreenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // Get the screenshot file
        File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Capture the location and size of the WebElement
        Point point = element.getLocation();
        int height = element.getSize().getHeight();
        int width = element.getSize().getWidth();
       

        // Crop the screenshot to the size of the WebElement
        File croppedScreenshotFile = new File("croppedScreenshot.png");
        try {
            BufferedImage bufferedImage = ImageIO.read(sourcefile);
            BufferedImage croppedImage = bufferedImage.getSubimage(point.getX(), point.getY(), width, height);
            ImageIO.write(croppedImage, "png", croppedScreenshotFile);
        } catch (IOException e) {
            System.err.println("Unable to crop screenshot: " + e.getMessage());
        }

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
            // Copy the cropped screenshot file to the destination
            FileHandler.copy(croppedScreenshotFile, destfile);
            System.out.println("Screenshot captured: " + destfile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Unable to capture screenshot: " + e.getMessage());
        } finally {
            // Delete the temporary cropped screenshot file
            croppedScreenshotFile.delete();
        }
    }

	}


