package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class BrowserLogTests extends TestBase {

    @Test
    public void testBrowserLogs() {
        app.admin().login();
        app.admin().getLogsForProducts();
    }
}
