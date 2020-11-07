package WorkFlows;
import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlows extends commonOps {

    @Step("Get Screen Info")
    public static void getScreenInfo(){
        uiActions.click(EAD_Main.side_info_btn_sysInfo);
        uiActions.click(EAD_Main.main_tlg_btn_screenInfo);
        uiActions.click(EAD_Main.main_tlg_btn_screenInfo);
        uiActions.click(EAD_Main.btn_viewDemo);
    }
}
