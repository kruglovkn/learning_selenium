package ru.stqa.training.selenium.Tests;

import org.junit.Test;

public class ShoppingCartTest extends TestBase {

    @Test
    public void testShoppingCart() {
        app.litecart().enter();
        app.addProduct().addProduct(3);
        app.deleteProduct().deleteProducts();
    }
}
