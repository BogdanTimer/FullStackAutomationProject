package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComRegister
{
    @FindBy(xpath = "//*[@id=\"FirstName\"]")
    public WebElement reg_fname;

    @FindBy(xpath = "//*[@id=\"LastName\"]")
    public WebElement reg_lname;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    public WebElement reg_email;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    public WebElement reg_pw;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    public WebElement reg_confpw;

    @FindBy(xpath = "//*[@id=\"register-button\"]")
    public WebElement reg_sumbit;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/form/div/div[2]/div[1]")
    public WebElement reg_success;
}
