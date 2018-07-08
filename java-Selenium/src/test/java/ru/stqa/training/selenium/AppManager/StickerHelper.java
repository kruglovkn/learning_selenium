package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

import static org.junit.Assert.assertEquals;
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


    public void checkProductProperties() {
        WebElement campaign = driver.findElement(By.cssSelector("#box-campaigns"));
        List<WebElement> products = campaign.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
        WebElement product = products.iterator().next();
        WebElement oldPrice = product.findElement(By.cssSelector(".regular-price"));
        WebElement newPrice = product.findElement(By.cssSelector(".campaign-price"));
        String textMainPage = product.findElement(By.cssSelector(".name")).getText();
        String priceMainPageOld = oldPrice.getText();
        String priceMainPageNew = newPrice.getText();
        Color color = Color.fromString(oldPrice.getCssValue("color"));
        assertEquals(color.getColor().getRed(), color.getColor().getGreen(), color.getColor().getBlue());
        Color newColor = Color.fromString(newPrice.getCssValue("color"));
        assertEquals(newColor.getColor().getBlue(), newColor.getColor().getGreen(), 0);
        assertTrue(newPrice.getCssValue("font-size").compareTo(oldPrice.getCssValue("font-size"))>0);
        assertTrue(oldPrice.getCssValue("font-weight").equals("400"));
        assertTrue(newPrice.getCssValue("font-weight").compareTo("600")>0);
        assertTrue(oldPrice.getCssValue("text-decoration").contains("line-through"));

        product.click();
        WebElement table = driver.findElement(By.cssSelector("#box-product"));
        WebElement oldPriceProductPage = driver.findElement(By.cssSelector(".regular-price"));
        WebElement newPriceProductPage = driver.findElement(By.cssSelector(".campaign-price"));
        String textProductPage = driver.findElement(By.cssSelector("h1[itemprop = name]")).getText();
        String priceProductPageOld = oldPriceProductPage.getText();
        String priceProductPageNew = newPriceProductPage.getText();
        Color colorProductPage = Color.fromString(oldPriceProductPage.getCssValue("color"));
        assertEquals(colorProductPage.getColor().getRed(), colorProductPage.getColor().getGreen(),
                colorProductPage.getColor().getBlue());
        Color newColorProductPage = Color.fromString(newPriceProductPage.getCssValue("color"));
        assertEquals(newColorProductPage.getColor().getBlue(), newColorProductPage.getColor().getGreen(), 0);
        assertTrue(newPriceProductPage.getCssValue("font-size").compareTo(oldPriceProductPage.getCssValue("font-size"))>0);
        assertTrue(oldPriceProductPage.getCssValue("font-weight").equals("400"));
        assertTrue(newPriceProductPage.getCssValue("font-weight").compareTo("600")>0);
        assertTrue(oldPriceProductPage.getCssValue("text-decoration").contains("line-through"));

        assertTrue(textMainPage.equals(textProductPage));
        assertTrue(priceMainPageOld.equals(priceProductPageOld));
        assertTrue(priceMainPageNew.equals(priceProductPageNew));
    }
}
