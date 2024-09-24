package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourCartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");

    @Override
    public void waitPageToLoad() {
        waitPage(checkoutButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina 'your cart'");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(checkoutButton).isDisplayed())
        );
    }

    public void clickCheckout() {
        Logs.info("Haciendo click en checkout");
        find(checkoutButton).click();
    }
}
