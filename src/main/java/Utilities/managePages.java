package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base {
    public static void init() {
        nopComLogin = PageFactory.initElements(driver, PageObjects.nopCom.nopComLogin.class);
        nopComMain = PageFactory.initElements(driver, PageObjects.nopCom.nopComMain.class);
        nopComDesktops = PageFactory.initElements(driver, PageObjects.nopCom.nopComDesktops.class);
        nopComBuildPC = PageFactory.initElements(driver, PageObjects.nopCom.nopComBuildPC.class);
        nopComCart = PageFactory.initElements(driver, PageObjects.nopCom.nopComCart.class);
        nopComCheckout = PageFactory.initElements(driver, PageObjects.nopCom.nopComCheckout.class);
        nopComFinalCheckout = PageFactory.initElements(driver, PageObjects.nopCom.nopComFinalCheckout.class);
        nopComCompletedOrder = PageFactory.initElements(driver, PageObjects.nopCom.nopComCompletedOrder.class);
        nopComRegister = PageFactory.initElements(driver, PageObjects.nopCom.nopComRegister.class);

        wazeMain = PageFactory.initElements(driver, PageObjects.someAndroidApp.wazeMain.class);
        wazeLeftMenu = PageFactory.initElements(driver, PageObjects.someAndroidApp.wazeLeftMenu.class);
        wazeFindingMenu = PageFactory.initElements(driver, PageObjects.someAndroidApp.wazeFindingMenu.class);
        wazeDestinationMenu = PageFactory.initElements(driver, PageObjects.someAndroidApp.wazeDestinationMenu.class);

        EAD_Main = PageFactory.initElements(driver, PageObjects.ElectronAPIDemos.EAD_Main.class);

        CalcMain = PageFactory.initElements(driver, PageObjects.Calc.CalcMain.class);

    }
}