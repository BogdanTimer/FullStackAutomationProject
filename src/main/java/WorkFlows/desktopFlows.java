package WorkFlows;

import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class desktopFlows extends commonOps {
    @Step("Calculate: plus")
    public static void calcForMe(){
        uiActions.click(CalcMain.btn_clear);
        uiActions.click(CalcMain.btn_one);
        uiActions.click(CalcMain.btn_plus);
        uiActions.click(CalcMain.btn_seven);
        uiActions.click(CalcMain.btn_equals);
    }
}
