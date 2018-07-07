package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class MenuTests extends TestBase {

    @Test
    public void testMenu() {
        app.menu().login();
        app.menu().menuCheck();


    }



}
