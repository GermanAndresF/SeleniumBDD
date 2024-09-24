package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(usernameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(passwordInput).isDisplayed()),
                () -> Assertions.assertTrue(find(loginButton).isDisplayed())
        );
    }

    public void fillLogin(String username, String password) {
        Logs.info("Escribiendo el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escribiendo el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Haciendo click en el boton de login");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String textoError) {
        final var errorLabel = find(errorMessage);

        Logs.info("Verificando el mensaje de error y su texto");
        Assertions.assertAll(
                () -> Assertions.assertTrue(errorLabel.isDisplayed()),
                () -> Assertions.assertEquals(errorLabel.getText(), textoError)
        );
    }
}
