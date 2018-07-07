package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class CountryTest extends TestBase {

    @Test
    public void testCountries() {
        app.menu().login();
        app.menu().countryCheck();
    }
}
