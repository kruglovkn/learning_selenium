package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class OpenNewWindowTest extends TestBase {

    @Test
    public void testNewWindow() {
        app.admin().login();
        app.admin().openNewWindow();

    }
}
