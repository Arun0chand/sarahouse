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

public class ScreenshotWebelement {

	public static void elementScreenshot(WebDriver driver,WebElement element,String screenshotName) {

         TakesScreenshot ts=(TakesScreenshot)driver;
         
         File source=ts.getScreenshotAs(OutputType.FILE);
         
         Point point=element.getLocation();
         int height=element.getSize().getHeight();
         int width=element.getSize().getWidth();
         
         File croppedscreenshotfile=new File("croppedscreenshot.png");
         try {
        	 BufferedImage bufferedimage=ImageIO.read(source);
        	 BufferedImage croppedimage=bufferedimage.getSubimage(point.getX(), point.getY(), width, height);
        	 ImageIO.write(croppedimage, "png", croppedscreenshotfile);
         }catch(Exception e) {
        	 System.out.println("Unable to take a screenshot"+e.getMessage());
         }
         
         String destinationdirectory="imagesstored/";
         File directory=new File(destinationdirectory);
         if(!directory.exists()) {
        	 directory.mkdirs();
         }
         
         String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
         
         File destfile=new File(destinationdirectory+screenshotName+" "+timestamp+".png");
         
         try {
        	 FileHandler.copy(croppedscreenshotfile, destfile);
        	 System.out.println("Screen shot captured"+destfile.getAbsolutePath());
         }catch(Exception e) {
        	 System.out.println("Unable to take screenshot"+e.getMessage());
         }finally {
        	 croppedscreenshotfile.delete();
         }
	}
}



