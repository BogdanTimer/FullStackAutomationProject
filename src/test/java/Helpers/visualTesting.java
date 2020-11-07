package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class visualTesting extends commonOps {
    @Test
    public void createScreenshot() throws InterruptedException {
        Thread.sleep(2999);
        helperMethods.takeElementScreenshot(nopComMain.nop_logo, "logo.ver1.0");
    }
}
