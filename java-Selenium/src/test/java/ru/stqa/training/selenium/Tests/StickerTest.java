package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class StickerTest extends TestBase {

    @Test
    public void testStickers() {
        app.sticker().enter();
        app.sticker().checkStickers();

    }
}
