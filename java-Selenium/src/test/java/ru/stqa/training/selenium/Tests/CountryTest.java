package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class CountryTest extends TestBase {

    @Test
    public void testCountries() {
        app.admin().login();
        app.admin().countryCheck();
    }


}
