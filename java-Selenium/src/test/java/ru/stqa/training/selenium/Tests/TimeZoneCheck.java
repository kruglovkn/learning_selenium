package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class TimeZoneCheck extends TestBase {

    @Test
    public void testTimeZones() {
        app.menu().login();
        app.menu().checkTimeZone();
    }
}
