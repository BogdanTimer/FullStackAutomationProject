package SanityTests;

import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class WazeMobile extends commonOps {
    @Test(description = "Test 01: Find destination and check same distance")
    @Description("Test description: This test shows us finding destination and checking same distances")
    public void tc01_findAndCheckDist() {
        mobileFlows.findTextDestination("Rothschild 87");
        verifications.distanceCheck(wazeDestinationMenu.txt_previewPlaceDistance);
    }
}
