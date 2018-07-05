package ru.stqa.training.selenium.AppManager;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private MenuHelper menuHelper;


    public MenuHelper menu() {
        return menuHelper;
    }
    WebDriver driver;
    WebDriverWait wait;


    public void init() {
        if (driver != null){
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        menuHelper = new MenuHelper(driver);


        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    }

    public void close() {
        // driver.quit();
        // driver = null;
    }
}