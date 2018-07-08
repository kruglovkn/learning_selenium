package ru.stqa.training.selenium.Tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.AppManager.ApplicationManager;

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
