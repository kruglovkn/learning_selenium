package ru.stqa.training.selenium.AppManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.ShoppingCart.AddProductToCart;
import ru.stqa.training.selenium.ShoppingCart.DeleteProductFromCart;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private AdminLitecartHelper adminLitecartHelper;
    private LitecartHelper litecartHelper;
    private DeleteProductFromCart deleteFromCart;
    private AddProductToCart addToCart;


    public AdminLitecartHelper admin() {
        return adminLitecartHelper;
    }

    public LitecartHelper litecart() {
        return litecartHelper;
    }
    WebDriver driver;
    WebDriverWait wait;

    public DeleteProductFromCart deleteProduct() {return deleteFromCart;}
    public AddProductToCart addProduct() {return addToCart;}


    public void init() {
        if (driver != null){
           return;
        }
        driver = new ChromeDriver();
        //FirefoxOptions options = new FirefoxOptions().setLegacy(true);
       // driver = new FirefoxDriver(options);
        //driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        adminLitecartHelper = new AdminLitecartHelper(driver,wait);
        litecartHelper = new LitecartHelper(driver,wait);
        deleteFromCart = new DeleteProductFromCart(driver,wait);
        addToCart = new AddProductToCart(driver,wait);



        //Runtime.getRuntime().addShutdownHook(
          //      new Thread(() -> { driver.quit(); driver = null; }));
    }

    public void close() {
         driver.quit();
         driver = null;
    }
}
