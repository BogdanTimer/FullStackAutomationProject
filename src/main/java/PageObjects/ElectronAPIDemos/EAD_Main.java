package PageObjects.ElectronAPIDemos;

//Only one page object created. I pretty must showed that I know how to use it
//But for simplicity sake I will create only one for electron example.

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EAD_Main {
    @FindBy(id = "button-app-sys-information")
    public WebElement side_info_btn_sysInfo;

    @FindBy(id = "screen-info-demo-toggle")
    public WebElement main_tlg_btn_screenInfo;

    @FindBy(id = "screen-info")
    public WebElement btn_viewDemo;

    @FindBy(id = "got-screen-info")
    public WebElement txt_screenInfo;

}
