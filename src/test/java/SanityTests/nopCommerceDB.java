package SanityTests;

import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class nopCommerceDB extends commonOps {
    @Test(description = "Test 02.5: Log in to nopCommerce with credentials from database")
    @Description("Test description: This test shows us login process with credentials from database")
    public void tc02_5_Login() throws InterruptedException {
        webFlows.loginDB();
        verifications.textInElement(nopComMain.btn_logout, "Log out");
    }
}
