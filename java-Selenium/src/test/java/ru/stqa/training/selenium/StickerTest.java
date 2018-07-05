package ru.stqa.training.selenium;

import org.junit.Test;

public class StickerTest extends TestBase{

    @Test
    public void testStickers() {
        app.sticker().enter();
        app.sticker().checkStickers();

    }
}
