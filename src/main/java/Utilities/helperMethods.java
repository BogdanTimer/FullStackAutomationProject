package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps {
    public static void takeElementScreenshot(WebElement imageElement, String imageName) {
        imageScreenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, imageElement);
        try {
            ImageIO.write(imageScreenshot.getImage(), "PNG", new File(getData("imgRep") + imageName + ".png"));
        } catch (Exception e) {
            System.out.println("Error writing image file. See details: " + e);
        }
    }

}
