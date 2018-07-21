package ru.stqa.training.selenium.ShoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.AppManager.HelperBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class AddProductToCart extends HelperBase {
    public AddProductToCart(WebDriver driver, WebDriverWait wait)  {
        super(driver,wait);
    }


    public void addProduct(int i) {
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
}
