package PageObjects.someAndroidApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class wazeFindingMenu {
    @FindBy(xpath="(//*[@id='searchItemsList']/*[./*[./*[@id='acDistance']]])")
    public List<WebElement> findingResults;

    @FindBy(xpath ="(//*[@id='searchItemsList']/*/*/*/*[@id='acDistanceAmount'])")
    public List<WebElement> findingResultsDistances;

}
