package PageObjects.someAndroidApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wazeDestinationMenu {
    @FindBy(id="addressPreviewPlaceDistance")
    public WebElement txt_previewPlaceDistance;

    @FindBy(id="addressPreviewGoButtonText")
    public WebElement btn_Go;
}
