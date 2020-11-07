package WorkFlows;

import Extentions.dbActions;
import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.List;

public class webFlows extends commonOps {
    @Step("Insert valid data into register form and submit")
    public static void nopComRegister(String firstname, String lastname,
                                      String email, String pw, String confirmPW) throws InterruptedException {
        Thread.sleep(2000);
        uiActions.updateText(nopComRegister.reg_fname, firstname);
        uiActions.updateText(nopComRegister.reg_lname, lastname);
        uiActions.updateText(nopComRegister.reg_email, email);
        uiActions.updateText(nopComRegister.reg_pw, pw);
        uiActions.updateText(nopComRegister.reg_confpw, confirmPW);
        uiActions.click(nopComRegister.reg_sumbit);
    }

    @Step("Login into nopCommerce")
    public static void login(String email, String password) throws InterruptedException {
        uiActions.click(nopComMain.btn_login);
        Thread.sleep(2000);
        uiActions.updateText(nopComLogin.lgn_email, email);
        uiActions.updateText(nopComLogin.lgn_pw, password);
        uiActions.click(nopComLogin.lgn_lgn);
    }

    @Step("Login into nopCommerce with credentials from DB")
    public static void loginDB() throws InterruptedException {
        List<String> cred = dbActions.getCredentials("SELECT Login, Password FROM admin WHERE id ='2'");
        uiActions.click(nopComMain.btn_login);
        Thread.sleep(2000);
        uiActions.updateText(nopComLogin.lgn_email, cred.get(0));
        uiActions.updateText(nopComLogin.lgn_pw, cred.get(1));
        uiActions.click(nopComLogin.lgn_lgn);
    }

    @Step("Insert valid data into billing form")
    public static void fillBillingAndContinue(String city, String address,
                                              String zip, String phoneNum) {
        uiActions.updateText(nopComCheckout.txt_city, city);
        uiActions.updateText(nopComCheckout.txt_address, address);
        uiActions.updateText(nopComCheckout.txt_zip, zip);
        uiActions.updateText(nopComCheckout.txt_phoneNumber, phoneNum);
        uiActions.click(nopComCheckout.btn_billingContinue);
    }

    @Step("Pressing continue multiple times")
    public static void multipleClicking() {
        uiActions.click(nopComCheckout.btn_shippingContinue);
        uiActions.click(nopComCheckout.btn_paymentContinue);
        uiActions.click(nopComCheckout.btn_paymentInfoContinue);
        uiActions.click(nopComFinalCheckout.btn_confirmOrder);
    }

    @Step("Check terms and press checkout")
    public static void termsAndProceed() throws InterruptedException {
        Thread.sleep(2000);
        uiActions.click(nopComCart.btn_terms);
        uiActions.click(nopComCart.btn_checkout);
    }


    @Step("Add PC With lowest settings to cart")
    public static void addPC() throws InterruptedException {
        uiActions.HoverHoverNClick(nopComMain.btn_topmenu_comps, nopComMain.btn_topmenu_desktops);
        Thread.sleep(3000);
        uiActions.click(nopComDesktops.desk_pcAddToCart);
        uiActions.updateDropDown(nopComBuildPC.processor_list, "2.2 GHz Intel Pentium Dual-Core E2200");
        uiActions.click(nopComBuildPC.firstHDD_btn);
        uiActions.click(nopComBuildPC.btn_addToCart);
    }
}