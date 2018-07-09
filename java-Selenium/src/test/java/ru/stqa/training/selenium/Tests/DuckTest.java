package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class DuckTest extends  TestBase {

    @Test
    public void testDuks() {
        app.litecart().enter();
        app.litecart().checkProductProperties();

    }
}
