package ru.stqa.training.selenium.AppManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private AdminLitecartHelper adminLitecartHelper;
    private LitecartHelper litecartHelper;


    public AdminLitecartHelper admin() {
        return adminLitecartHelper;
    }

    public LitecartHelper litecart() {
        return litecartHelper;
    }
    WebDriver driver;
    WebDriverWait wait;


    public void init() {
        if (driver != null){
           return;
        }
        driver = new ChromeDriver();
        //FirefoxOptions options = new FirefoxOptions().setLegacy(true);
       // driver = new FirefoxDriver(options);
        //driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        adminLitecartHelper = new AdminLitecartHelper(driver);
        litecartHelper = new LitecartHelper(driver);



        //Runtime.getRuntime().addShutdownHook(
          //      new Thread(() -> { driver.quit(); driver = null; }));
    }

    public void close() {
         driver.quit();
         driver = null;
    }
}
