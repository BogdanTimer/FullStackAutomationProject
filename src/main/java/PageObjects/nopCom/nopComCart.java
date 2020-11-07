package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class nopComCart
{
    @FindBy(id = "termsofservice")
    public WebElement btn_terms;

    @FindBy(id = "checkout")
    public WebElement btn_checkout;

    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr")
    public List<WebElement> numberOfItems;

}
