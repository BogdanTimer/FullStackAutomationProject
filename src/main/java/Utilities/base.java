package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imageDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static String savedText;

    public static PageObjects.nopCom.nopComLogin nopComLogin;
    public static PageObjects.nopCom.nopComMain nopComMain;
    public static PageObjects.nopCom.nopComDesktops nopComDesktops;
    public static PageObjects.nopCom.nopComBuildPC nopComBuildPC;
    public static PageObjects.nopCom.nopComCart nopComCart;
    public static PageObjects.nopCom.nopComCheckout nopComCheckout;
    public static PageObjects.nopCom.nopComFinalCheckout nopComFinalCheckout;
    public static PageObjects.nopCom.nopComCompletedOrder nopComCompletedOrder;
    public static PageObjects.nopCom.nopComRegister nopComRegister;

    public static PageObjects.someAndroidApp.wazeMain wazeMain;
    public static PageObjects.someAndroidApp.wazeLeftMenu wazeLeftMenu;
    public static PageObjects.someAndroidApp.wazeFindingMenu wazeFindingMenu;
    public static PageObjects.someAndroidApp.wazeDestinationMenu wazeDestinationMenu;

    public static PageObjects.ElectronAPIDemos.EAD_Main EAD_Main;

    public static PageObjects.Calc.CalcMain CalcMain;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static String Platform;
}