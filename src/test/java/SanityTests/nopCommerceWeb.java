package SanityTests;

import Extentions.uiActions;
import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class nopCommerceWeb extends commonOps {

    @Test(description = "Test 01: Register on nopCommerce")
    @Description("Test description: This test shows us register flow")
    public void tc01_registerAndLogout() throws InterruptedException {
        uiActions.click(nopComLogin.btn_register);
        webFlows.nopComRegister(getUserData("other"), getUserData("other"),
                getUserData("email"), getUserData("other"), getUserData("other"));
        verifications.textInElement(nopComRegister.reg_success, "Your registration completed");
        Thread.sleep(3000);
        uiActions.click(nopComMain.btn_logout);
    }

    @Test(description = "Test 02: Log in to nopCommerce")
    @Description("Test description: This test shows us login process")
    public void tc02_Login() throws InterruptedException {
        webFlows.login(getUserData("email"), getUserData("other"));
        verifications.textInElement(nopComMain.btn_logout, "Log out");
    }

    @Test(description = "Test 03: Add PC to cart")
    @Description("Test description: This test shows us item adding process")
    public void tc03_addPC() throws InterruptedException {
        webFlows.addPC();
        verifications.addSuccess(nopComBuildPC.bar_success);
    }

    @Test(description = "Test 04: Quantity after adding item")
    @Description("Test description: This test verifies amount of items added against expected amount")
    public void tc04_checkQtyAndProceedToCheckOut() {
        uiActions.HoverHoverNClick(nopComBuildPC.btn_cart, nopComBuildPC.btn_goToCart);
        verifications.numberOfElements(nopComCart.numberOfItems, 1);
    }

    @Test(description = "Test 05: Fill billing data and complete order")
    @Description("Test description: This test verifies whether the ordered was completed or not with valid data inserted")
    public void tc05_completeCheckout() throws InterruptedException {
        uiActions.HoverHoverNClick(nopComBuildPC.btn_cart, nopComBuildPC.btn_goToCart);
        webFlows.termsAndProceed();
        uiActions.updateDropDown(nopComCheckout.list_country, "United States");
        Thread.sleep(3000);
        uiActions.updateDropDown(nopComCheckout.list_state, "Alabama");
        webFlows.fillBillingAndContinue("999",
                "888", "777", "665");
        webFlows.multipleClicking();
        Thread.sleep(10000);
        verifications.textInElement(nopComCompletedOrder.txt_orderSuccess, "Thank you");
    }

    @Test(description = "Test 06: nopCommerce logo")
    @Description("Test description: This test verifies that logo has not changed")
    public void tc06_verifyLogo() {
        verifications.visualElement(nopComMain.nop_logo, "logo.ver1.0");
    }
}
