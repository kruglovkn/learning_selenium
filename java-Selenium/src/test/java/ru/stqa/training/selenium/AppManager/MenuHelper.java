package ru.stqa.training.selenium.AppManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

    public void countryCheck() {
        click(By.linkText("Countries"));
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
        click(By.linkText("Countries"));
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
        click(By.linkText("Geo Zones"));
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

}
