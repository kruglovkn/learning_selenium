package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class LitecartHelper extends HelperBase{

    public LitecartHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void enter() {
        driver.get("http://localhost/litecart");
    }

    public void checkStickers() {
        List<WebElement> items = driver.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
        for (WebElement item : items)
            assertTrue(item.findElements(By.xpath(".//div[contains(@class,'litecart')]")).size()==1);
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

    public void createAcc(String taxId, String company, String name, String lastname,
                          String address, String postcode, String city, String state,
                          String email, String phone, String password) {
        driver.get("http://localhost/litecart/en/create_account");
        type(By.cssSelector("[name = tax_id]"), taxId);
        type(By.cssSelector("[name = company]"), company);
        type(By.cssSelector("[name = firstname]"), name);
        type(By.cssSelector("[name = lastname]"), lastname);
        type(By.cssSelector("[name = address1]"), address);
        type(By.cssSelector("[name = postcode]"), postcode);
        type(By.cssSelector("[name = city]"), city);
        //Select selectCountry = new Select(driver.findElement(By.cssSelector(".select2-selection.select2-selection--single")));
        //selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.cssSelector("select[name = zone_code]")));
        selectState.selectByVisibleText(state);
        type(By.cssSelector("[name = email]"), email);
        type(By.cssSelector("[name = phone]"), phone);
        type(By.cssSelector("[name = password]"), password);
        type(By.cssSelector("[name = confirmed_password]"), password);
        click(By.cssSelector("button[type = submit]"));
    }


    public void exit() {
        click(By.linkText("Logout"));

    }

    public void loginToLitecart(String email, String password) {
        enter();
        type(By.cssSelector("[name = email]"), email);
        type(By.cssSelector("[name = password]"), password);
        click(By.cssSelector("button[name = login]"));

    }

    public void eddProduct(int i) {
        int n = 1;
        while (n <= i ) {
            List<WebElement> products = driver.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
            products.iterator().next().click();
            if (isElementPresent(By.cssSelector("[name = 'options[Size]']"))) {
                Select selectSize = new Select(driver.findElement(By.cssSelector("[name = 'options[Size]']")));
                selectSize.selectByValue("Medium");
            }
            click(By.cssSelector("[name = add_cart_product]"));
            wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), String.valueOf(n)));
            click(By.cssSelector("#logotype-wrapper"));
            n++;
        }
    }

    public void deleteProducts() {
        click(By.cssSelector("#cart"));
        List<WebElement> products = driver.findElements(By.cssSelector("li.shortcut"));
        for (int a = 0; a < products.size(); a++) {
            List<WebElement> tableRows = driver.
                    findElements(By.xpath("//table[@class = 'dataTable rounded-corners']//tr"));
            click(By.cssSelector("[name = remove_cart_item]"));
            if (a < (products.size() - 1)) {
                wait.until(numberOfElementsToBe(By.xpath("//table[@class = 'dataTable rounded-corners']//tr"),
                        (tableRows.size() - 1)));
            } else {wait.until(presenceOfElementLocated(By.cssSelector("em")));}
        }
    }
}
