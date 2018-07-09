package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class TimeZoneTest extends TestBase {

    @Test
    public void testTimeZones() {
        app.admin().login();
        app.admin().checkTimeZone();
    }

    @Test
    public void testTimeZonesFromMenu() {
        app.admin().login();
        app.admin().checkTimeZoneFromMenu();
    }
}
