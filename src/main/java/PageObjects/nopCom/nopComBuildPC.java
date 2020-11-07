package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class nopComBuildPC
{
    @FindBy(xpath = "//*[@id=\"product_attribute_1\"]")
    public WebElement processor_list;

    @FindBy(id = "product_attribute_3_6")
    public WebElement firstHDD_btn;

    @FindBy(id = "add-to-cart-button-1")
    public WebElement btn_addToCart;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    public WebElement btn_cart;

    @FindBy(xpath = "//*[@id=\"flyout-cart\"]/div/div[4]/input")
    public WebElement btn_goToCart;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div")
    public WebElement bar_success;

}
