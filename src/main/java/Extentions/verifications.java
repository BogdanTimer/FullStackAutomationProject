package Extentions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;

import static org.testng.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class verifications extends commonOps {

    @Step("Verify text in element")
    public static void textInElement(WebElement elem, String expectedText) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron") && !Platform.equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        if (Platform.equalsIgnoreCase("desktop"))
            assertEquals(elem.getText().replaceAll("Display is", "").trim(), expectedText);
        else
            assertEquals(elem.getText(), expectedText);
    }

    @Step("Verify amount of items")
    public static void numberOfElements(List<WebElement> elems, int expectedValue) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expectedValue);
    }

    @Step("Verify success bar exists")
    public static void addSuccess(WebElement elem) {
        if (!Platform.equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify same distance from finding results and destination menu")
    public static void distanceCheck(WebElement elem) {
        assertTrue(elem.getText().contains(savedText));
    }

    @Step("Verify element visually")
    public static void visualElement(WebElement imageElement, String expectedImageName) {
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(getData("imgRep") + expectedImageName + ".png"));
        } catch (Exception e) {
            System.out.println("Error reading file. See details: " + e);
        }
        Screenshot imageScreenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenshot.getImage();
        diff = imageDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images are different");
    }

    @Step("Verify output text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify deleted student")
    public static void verifyDeletedStudent() {
        assertEquals(response.getStatusCode(), 204);
    }
}