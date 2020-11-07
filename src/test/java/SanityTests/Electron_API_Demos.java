package SanityTests;

import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class Electron_API_Demos extends commonOps {
    @Test(description = "Test 01: Get screen info and verify with expected")
    @Description("Test Description: Get screen information and verify with expected")
    public void test01_verifyScreenInfo() {
        electronFlows.getScreenInfo();
        verifications.textInElement(EAD_Main.txt_screenInfo,"Your screen is: 1920px x 1080px");
    }
}
