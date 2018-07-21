package ru.stqa.training.selenium.ShoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.AppManager.HelperBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DeleteProductFromCart extends HelperBase {
    public DeleteProductFromCart(WebDriver driver, WebDriverWait wait)  {
        super(driver,wait);
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
