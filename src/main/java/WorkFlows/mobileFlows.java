package WorkFlows;

import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps {
    @Step("Enter left menu, press onto type box and enter destination")
    public static void findTextDestination (String destination) {
        uiActions.click(wazeMain.btn_search);
        uiActions.click(wazeLeftMenu.typebox_whereto);
        uiActions.updateText(wazeLeftMenu.typebox_whereto, destination);
        uiActions.saveText(wazeFindingMenu.findingResultsDistances.get(0));
        uiActions.click(wazeFindingMenu.findingResults.get(0));
    }

}
