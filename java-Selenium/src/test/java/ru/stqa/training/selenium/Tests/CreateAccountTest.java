package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void testAccountCreation() {
        long i =System.currentTimeMillis();
        String email = "kruglovkn90+" + i + "@gmail.com";
        String password = "123456789";
        app.litecart().enter();
        app.litecart().createAcc("123456", "private", "Konstantin", "Kruglov",
                "21 High st. apt. 11", "01749", "Hudson",
                "Massachusetts", email, "+16176718890", password);
        app.litecart().exit();
        app.litecart().loginToLitecart(email, password);
        app.litecart().exit();

    }
}
