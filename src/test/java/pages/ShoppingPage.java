package pages;

import modelos.ItemProducto;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.BasePage;
import utilities.Logs;

import java.util.List;

public class ShoppingPage extends BasePage {
    private final By inventoryList = By.className("inventory_list");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By selectItem = By.className("product_sort_container");

    private By getProductPrice(String itemName) {
        return RelativeLocator
                .with(By.className("inventory_item_price"))
                .below(getItemName(itemName));
    }

    private By getItemName(String itemName) { //localizador dinamico
        final var xpath = String.format("//div[text()='%s']", itemName);
        return By.xpath(xpath);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina de shopping");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(inventoryList).isDisplayed()),
                () -> Assertions.assertTrue(find(productsTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(selectItem).isDisplayed())
        );
    }

    public void goToItemDetail(String itemName) {
        Logs.info("Navegando al detalle del item: %s", itemName);
        find(getItemName(itemName)).click();
    }

    public void verifyProductsPrice(List<ItemProducto> listaItems) {
        Logs.info("Verificando el precio de los productos");

        Assertions.assertAll(
                listaItems.stream().map(item -> () -> {
                    final var priceLabel = find(getProductPrice(item.getNombre()));
                    final var price = Double.parseDouble(
                            priceLabel.getText().replace("$", "")
                    );
                    Assertions.assertEquals(
                            price, //valor obtenido
                            item.getPrecio(), //valor esperado
                            String.format("fallo: %s", item.getNombre()) //mensaje de error si falla
                    );
                })
        );
    }
}
