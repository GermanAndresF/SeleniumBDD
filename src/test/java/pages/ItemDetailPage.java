package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ItemDetailPage extends BasePage {
    private final By itemName = By.className("inventory_details_name");
    private final By itemPrice = By.className("inventory_details_price");
    private final By itemImage = By.className("inventory_details_img");
    private final By itemDescription = By.className("inventory_details_desc");
    private final By addoToCartButton = By.id("add-to-cart");
    private final By backToProductsButton = By.id("back-to-products");

    @Override
    public void waitPageToLoad() {
        waitPage(itemName, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el detalle del item");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(itemName).isDisplayed()),
                () -> Assertions.assertTrue(find(itemPrice).isDisplayed()),
                () -> Assertions.assertTrue(find(itemImage).isDisplayed()),
                () -> Assertions.assertTrue(find(itemDescription).isDisplayed()),
                () -> Assertions.assertTrue(find(addoToCartButton).isDisplayed()),
                () -> Assertions.assertTrue(find(backToProductsButton).isDisplayed())
        );
    }

    public void clickBackToProducts() {
        Logs.info("Haciendo click en back to products");
        find(backToProductsButton).click();
    }
}
