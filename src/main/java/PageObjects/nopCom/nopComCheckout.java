package PageObjects.nopCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopComCheckout
{
    @FindBy(id = "billing-address-select")
    public WebElement list_address;
    //Used to handle when user already ordered before but took out, cause I think my tests are for new user;
    //User, that already bought is another scenario. I'm totally aware of this thing.

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
    public WebElement list_country;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_StateProvinceId\"]")
    public WebElement list_state;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement txt_city;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement txt_address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement txt_zip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement txt_phoneNumber;

    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
    public WebElement btn_billingContinue;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
    public WebElement btn_shippingContinue;

    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
    public WebElement btn_paymentContinue;

    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    public WebElement btn_paymentInfoContinue;

}
