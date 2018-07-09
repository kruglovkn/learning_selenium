package ru.stqa.training.selenium.Tests;

import org.junit.Test;

import java.io.File;

public class CreateProductTest extends TestBase {

    @Test
    public void testProductCreation() {
        File photo = new File("src/test/resources/image.jpg");
        long i =System.currentTimeMillis();
        String name = "Bread+" + i;
        app.admin().login();
        app.admin().createProduct(name,"12345", "100", "Temporary sold out",
                "08072018", "01102018", "ACME Corp.", "Bread basket",
                "Freash bread", "1", "US Dollars", "5", "4.5", photo);




    }
}
