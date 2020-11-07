package SanityTests;

import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.desktopFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class desktopCalculator extends commonOps {
    @Test(description = "Test 01: Addition")
    @Description("Test Description: This test verifies basic add action")
    public void test01_plusAction() {
        desktopFlows.calcForMe();
        verifications.textInElement(CalcMain.txt_result, "8");
    }
}
