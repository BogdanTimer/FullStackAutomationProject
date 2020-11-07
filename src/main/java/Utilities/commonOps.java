package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Parameters;
import org.w3c.dom.Document;


public class commonOps extends base {
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static String getUserData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/UserData.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("Firefox"))
            driver = initFFDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid platform name stated");
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);

    }

    public void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            driver = new RemoteWebDriver(new URL(getData("appiumserver") + "/wd/hub"), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    public void initAPI() {
        RestAssured.baseURI = getData("apiURL");
        httpRequest = RestAssured.given(); //.auth().preemptive().basic(getData("username"),getData("password")); //<- in case we have authentication process
    }

    public void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    public void initDesktop() {
        dc.setCapability("app", getData("app"));
        try {
            driver = new WindowsDriver(new URL(getData("appiumserver")), dc);
        } catch (Exception e) {
            System.out.println("Could not initiate desktop driver");
        }
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {

        Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (Platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (Platform.equalsIgnoreCase("api"))
            initAPI();
        else if (Platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (Platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
        manageDB.initConnection(getData("dbUrl"), getData("dbUsername"), getData("dbPassword"));
    }

    @BeforeMethod
    public void beforeMethod() {
        if (Platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession() {
        manageDB.closeConnection();
        if (!Platform.equalsIgnoreCase("api"))
            driver.quit();
    }
}