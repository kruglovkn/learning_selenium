package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class StickerTest extends TestBase {

    @Test
    public void testStickers() {
        app.litecart().enter();
        app.litecart().checkStickers();

    }
}
