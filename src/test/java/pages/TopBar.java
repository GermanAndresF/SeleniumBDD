package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBar extends BasePage {
    private final By title = By.xpath("//div[text=()='Swag Labs']");
    private final By menuBurger = By.id("react-burger-menu-btn");
    private final By shoppingButton = By.className("shopping_cart_link");


    @Override
    public void waitPageToLoad() {
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el top bar");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(title).isDisplayed()),
                () -> Assertions.assertTrue(find(menuBurger).isDisplayed())
        );
    }

    public void openMenuBurger() {
        Logs.info("Abriendo el menu burger");
        find(menuBurger).click();
    }

    public void clickShoppingCart() {
        Logs.info("Haciendo click en el boton de shoppingcart");
        find(shoppingButton).click();
    }
}
