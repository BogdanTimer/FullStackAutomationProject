package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComMain {
    @FindBy(css = "a[href='/computers']")
    public WebElement btn_topmenu_comps;

    @FindBy(css = "a[href='/desktops']")
    public WebElement btn_topmenu_desktops;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    public WebElement btn_logout;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    public WebElement btn_login;

    @FindBy(css = "img[alt='nopCommerce demo store']")
    public WebElement nop_logo;

}
