package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class TimeZoneTest extends TestBase {

    @Test
    public void testTimeZones() {
        app.menu().login();
        app.menu().checkTimeZone();
    }

    @Test
    public void testTimeZonesFromMenu() {
        app.menu().login();
        app.menu().checkTimeZoneFromMenu();
    }
}
