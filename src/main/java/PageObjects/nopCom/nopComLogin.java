package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComLogin {
    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    public WebElement btn_register;

    @FindBy(id = "Email")
    public WebElement lgn_email;

    @FindBy(id = "Password")
    public WebElement lgn_pw;

    @FindBy(css = "input[class='button-1 login-button']")
    public WebElement lgn_lgn;
}
