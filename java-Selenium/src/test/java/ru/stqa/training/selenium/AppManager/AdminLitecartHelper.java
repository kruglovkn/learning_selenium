package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AdminLitecartHelper extends HelperBase{
    public AdminLitecartHelper(WebDriver driver) {
        super(driver);
    }

    public void login() {
        driver.get("http://localhost/litecart/admin/login.php");
        type(By.name("username"),"admin");
        type(By.name("password"), "admin");
        click(By.name("login"));
    }

    public void menuCheck() {
        List<WebElement> menuFolders = driver.findElements(By.id("app-"));
        for (int a = 0; a < menuFolders.size(); a++) {
            menuFolders.get(a).click();
            Assert.assertTrue(isElementPresent(By.tagName("h1")));
            WebElement subMenu = driver.findElement(By.cssSelector("#app-.selected"));
            List<WebElement> subFolders = subMenu.findElements(By.xpath("//li[contains(@id,'doc-')]"));
            if (subFolders.size()!=0){
                for (int i = 0; i < subFolders.size(); i++) {
                    subFolders.get(i).click();
                    Assert.assertTrue(isElementPresent(By.tagName("h1")));
                    WebElement newSubMenu= driver.findElement(By.cssSelector("#app-.selected"));
                    subFolders = newSubMenu.findElements(By.xpath("//li[contains(@id,'doc-')]"));
                }
            }
            menuFolders = driver.findElements(By.id("app-"));
        }
    }

    public void countryCheck() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<String> countries = new ArrayList<String>();
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class = 'row']"));
        for (int i=0; i<rows.size(); i++ ) {
            WebElement cell = rows.get(i).findElement(By.xpath(".//td[5]"));
            WebElement country = cell.findElement(By.cssSelector("a"));
            String countryName = country.getText();
            countries.add(countryName);
        }
        for (int i=0; i <countries.size()-1; i++) {
            Assert.assertTrue((countries.get(i).compareTo(countries.get(i+1)))<0);
        }
    }

    public void checkTimeZone() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class = 'row']"));
        for (int i = 0; i < rows.size(); i++) {
            if (!(rows.get(i).findElement(By.xpath(".//td[6]")).getText()).equals("0")) {
                rows.get(i).findElement(By.xpath(".//td[5]")).findElement(By.cssSelector("a")).click();
                WebElement table = driver.findElement(By.cssSelector("#table-zones"));
                List<String> timeZones = new ArrayList<String>();
                List<WebElement> timeRows = table.findElements(By.cssSelector("tr"));
                for (int a = 1; a < timeRows.size()-1; a++) {
                    String timeZone = timeRows.get(a).findElement(By.xpath(".//td[3]")).getText();
                    timeZones.add(timeZone);
                }
                for (int t = 0; t < timeZones.size()-1; t++) {
                    Assert.assertTrue((timeZones.get(t).compareTo(timeZones.get(t + 1))) < 0);
                }
                driver.navigate().back();
                rows = driver.findElements(By.xpath(".//tr[@class = 'row']"));
            }
        }
    }

    public void checkTimeZoneFromMenu() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class = 'row']"));
        for (int i = 0; i < rows.size(); i++) {
                rows.get(i).findElement(By.xpath(".//td[5]")).findElement(By.cssSelector("a")).click();
                WebElement table = driver.findElement(By.cssSelector("#table-zones"));
                List<String> timeZones = new ArrayList<String>();
                List<WebElement> timeRows = table.findElements(By.cssSelector("tr"));
                for (int a = 1; a < timeRows.size()-1; a++) {
                    String timeZone = timeRows.get(a).findElement(By.xpath(".//td[3]")).
                            findElement(By.xpath(".//option[@selected = 'selected']")).getText();
                    timeZones.add(timeZone);
                }
                for (int t = 0; t < timeZones.size()-1; t++) {
                    Assert.assertTrue((timeZones.get(t).compareTo(timeZones.get(t + 1))) < 0);
                }
                driver.navigate().back();
                rows = driver.findElements(By.xpath(".//tr[@class = 'row']"));

        }
    }

    public void createProduct(String productName, String productCode,String quantity, String status, String dataFrom,
                              String dataTo, String madeBy, String shortDescription, String text, String purchasePrice,
                              String currencyType,String price, String priceEUR, File photo) {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        click(By.xpath("//a[contains(@href,'edit_product')]"));
        WebElement statusField = driver.findElement(By.cssSelector("label"));
        statusField.findElement(By.cssSelector("input[value = '1']")).click();
        type(By.cssSelector("[name = 'name[en]']"), productName);
        type(By.cssSelector("[name = code]"), productCode);
        click(By.cssSelector("input[value = '1-3']"));
        type(By.cssSelector("input[name = quantity]"), quantity);
        Select sold = new Select(driver.findElement(By.cssSelector("[name = sold_out_status_id]")));
        sold.selectByVisibleText(status);
        attach(By.cssSelector("input[name = 'new_images[]']"), photo);
        driver.findElement(By.cssSelector("[name = date_valid_from]")).sendKeys(dataFrom);
        driver.findElement(By.cssSelector("[name = date_valid_to]")).sendKeys(dataTo);
        click(By.cssSelector("[href = '#tab-information']"));
        Select manufacturer = new Select(driver.findElement(By.cssSelector("[name = manufacturer_id]")));
        manufacturer.selectByVisibleText(madeBy);
        type(By.cssSelector("[name = keywords]"), productName);
        type(By.cssSelector("[name = 'short_description[en]']"), shortDescription);
        type(By.cssSelector(".trumbowyg-editor"),text);
        type(By.cssSelector("[name = 'head_title[en]']"), productName);
        type(By.cssSelector("[name = 'meta_description[en]']"), shortDescription);
        click(By.cssSelector("[href = '#tab-prices']"));
        type(By.cssSelector("[name = purchase_price]"),purchasePrice);
        Select currancy = new Select(driver.findElement(By.cssSelector("[name = purchase_price_currency_code]")));
        currancy.selectByVisibleText(currencyType);
        driver.findElement(By.cssSelector("[name = 'prices[USD]']")).sendKeys(price);
        driver.findElement(By.cssSelector("[name = 'prices[EUR]']")).sendKeys(priceEUR);
        click(By.cssSelector("button[name = save]"));

        Assert.assertTrue(isElementPresent(By.linkText(productName)));
    }



}
