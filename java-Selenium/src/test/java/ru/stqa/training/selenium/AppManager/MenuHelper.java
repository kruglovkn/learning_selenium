package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuHelper extends HelperBase{
    public MenuHelper(WebDriver driver) {
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
        for (WebElement menuFolder: menuFolders) {
            menuFolder.click();
            Assert.assertTrue(isElementPresent(By.tagName("h1")));
            WebElement subMenu = driver.findElement(By.cssSelector("#app-.selected"));
            List<WebElement> subFolders = subMenu.findElements(By.xpath("//li[contains(@id,'doc-')]"));
            if (subFolders.size()!=0){
                for (WebElement subFolder: subFolders) {
                    subFolder.click();
                    Assert.assertTrue(isElementPresent(By.tagName("h1")));
                }
            }
            driver.navigate().back();
        }
        /*click(By.linkText("Appearence"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Template')]")));

        click(By.id("doc-template"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Template')]")));

        click(By.id("doc-logotype"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Logotype')]")));

        click(By.linkText("Catalog"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Catalog')]")));

        click(By.id("doc-catalog"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Catalog')]")));

        click(By.id("doc-product_groups"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Product Groups')]")));

        click(By.id("doc-option_groups"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Option Groups')]")));

        click(By.id("doc-manufacturers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Manufacturers')]")));

        click(By.id("doc-suppliers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Suppliers')]")));

        click(By.id("doc-delivery_statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Delivery Statuses')]")));

        click(By.id("doc-sold_out_statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Sold Out Statuses')]")));

        click(By.id("doc-quantity_units"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Quantity Units')]")));

        click(By.id("doc-csv"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'CSV Import/Export')]")));

        click(By.linkText("Countries"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Countries')]")));

        click(By.linkText("Currencies"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Currencies')]")));

        click(By.linkText("Customers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Customers')]")));

        click(By.id("doc-customers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Customers')]")));

        click(By.id("doc-csv"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'CSV Import/Export')]")));

        click(By.id("doc-newsletter"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Newsletter')]")));

        click(By.linkText("Geo Zones"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Geo Zones')]")));

        click(By.linkText("Languages"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Languages')]")));

        click(By.id("doc-languages"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Languages')]")));

        click(By.id("doc-storage_encoding"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Storage Encoding')]")));

        click(By.linkText("Modules"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Job Modules')]")));

        click(By.id("doc-jobs"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Job Modules')]")));

        click(By.id("doc-customer"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Customer Modules')]")));

        click(By.id("doc-shipping"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Shipping Modules')]")));

        click(By.id("doc-payment"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Payment Modules')]")));

        click(By.id("doc-order_total"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Order Total Modules')]")));

        click(By.id("doc-order_success"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Order Success Modules')]")));

        click(By.id("doc-order_action"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Order Action Modules')]")));

        click(By.linkText("Orders"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Orders')]")));

        click(By.id("doc-orders"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Orders')]")));

        click(By.id("doc-order_statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Order Statuses')]")));

        click(By.linkText("Pages"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Pages')]")));

        click(By.linkText("Reports"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Monthly Sales')]")));

        click(By.id("doc-monthly_sales"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Monthly Sales')]")));

        click(By.id("doc-most_sold_products"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Most Sold Products')]")));

        click(By.id("doc-most_shopping_customers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Most Shopping Customers')]")));

        click(By.linkText("Settings"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-store_info"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-defaults"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-general"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-listings"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-images"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-checkout"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-advanced"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.id("doc-security"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Settings')]")));

        click(By.linkText("Slides"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Slides')]")));

        click(By.linkText("Tax"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Tax Classes')]")));

        click(By.id("doc-tax_classes"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Tax Classes')]")));

        click(By.id("doc-tax_rates"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Tax Rates')]")));

        click(By.linkText("Translations"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Search Translations')]")));

        click(By.id("doc-search"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Search Translations')]")));

        click(By.id("doc-scan"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Scan Files For Translations')]")));

        click(By.id("doc-csv"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'CSV Import/Export')]")));

        click(By.linkText("Users"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Users')]")));

        click(By.linkText("vQmods"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'vQmods')]")));

        click(By.id("doc-vqmods"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'vQmods')]")));*/

    }
}
