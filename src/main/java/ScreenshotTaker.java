import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Contains the functionality for taking screenshots.
 * @author Brendan Lee
 */
public class ScreenshotTaker {
    public ScreenshotTaker(){
    }

    /**
     * Takes a screenshot and saves it as "screenshot.png" in the root folder.
     * The previous screenshot.png is overwritten.
     */
    public void takeScreenShot(){
        BufferedImage image = null;

        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            System.out.println("A screenshot could not be taken.");
            return;
        }
        try {
            ImageIO.write(image, "png", new File("screenshot.png"));
        } catch (IOException e) {
            System.out.println("The taken screenshot could not be saved.");
        }
    }
}
