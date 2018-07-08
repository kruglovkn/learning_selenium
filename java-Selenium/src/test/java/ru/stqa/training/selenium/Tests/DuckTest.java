package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class DuckTest extends  TestBase {

    @Test
    public void testDuks() {
        app.sticker().enter();
        app.sticker().checkProductProperties();

    }
}
