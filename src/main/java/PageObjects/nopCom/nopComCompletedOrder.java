package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComCompletedOrder
{

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    public WebElement txt_orderSuccess;
}
