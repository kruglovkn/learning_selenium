package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StickerHelper extends HelperBase{

    public StickerHelper(WebDriver driver) {
        super(driver);
    }

    public void enter() {
        driver.get("http://localhost/litecart");
    }

    public void checkStickers() {
        List<WebElement> items = driver.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
        for (WebElement item : items)
            assertTrue(item.findElements(By.xpath(".//div[contains(@class,'sticker')]")).size()==1);
    }
}
