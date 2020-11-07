package Extentions;

import Utilities.commonOps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class uiActions extends commonOps {

    @Step("Click")
    public static void click(WebElement elem) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron") && !Platform.equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        //wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Send text into text field")
    public static void updateText(WebElement elem, String value) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(value);
    }

    @Step("Choose value from dropdown")
    public static void updateDropDown(WebElement elem, String value) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue = new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("Mouse hover to element and click")
    public static void HoverHoverNClick(WebElement elem1, WebElement elem2) {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).build().perform();
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elem2));
        action.moveToElement(elem2).click().build().perform();
    }

    @Step("Saving text")
    public static void saveText(WebElement elem) {
        savedText = elem.getText();
    }


}