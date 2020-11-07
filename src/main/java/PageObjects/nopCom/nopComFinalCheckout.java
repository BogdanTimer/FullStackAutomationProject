package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComFinalCheckout
{
    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    public WebElement btn_confirmOrder;

}
