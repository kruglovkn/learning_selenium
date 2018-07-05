package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.AppManager.ApplicationManager;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    public ApplicationManager getApp() {
        return app;
    }

    @Before
    public void start() {
        app.init();
    }



    @After
    public void stop() {
       app.close();
    }
}
