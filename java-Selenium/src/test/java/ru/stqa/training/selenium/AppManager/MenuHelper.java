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
}
