package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MenuTests extends TestBase {

    @Test
    public void testMenu() {
        app.menu().login();
        app.menu().menuCheck();


    }



}
