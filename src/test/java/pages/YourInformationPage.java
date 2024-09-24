package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourInformationPage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipcodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorLabel = By.cssSelector("h3[data-test='error']");

    @Override
    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(firstNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(lastNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(zipcodeInput).isDisplayed()),
                () -> Assertions.assertTrue(find(continueButton).isDisplayed())
        );
    }

    public void fillData(String name, String lastname, String zipcode) {
        if (!name.isEmpty()) { //si el name es vacio no escribo nada
            Logs.info("Escribiendo el firstname");
            find(firstNameInput).sendKeys(name);
        }

        if (!name.isEmpty()) { //si el lastname es vacio no escribo nada
            Logs.info("Escribiendo el lastname");
            find(lastNameInput).sendKeys(lastname);
        }

        if (!name.isEmpty()) { //si el zipcode es vacio no escribo nada
            Logs.info("Escribiendo el zipcode");
            find(zipcodeInput).sendKeys(zipcode);
        }

        Logs.info("Haciendo click en continue");
        find(continueButton).click();
    }

    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Verificando el mensaje de error");
        final var errorLabelElement = find(errorLabel);

        Assertions.assertAll(
                () -> Assertions.assertTrue(errorLabelElement.isDisplayed()),
                () -> Assertions.assertEquals(errorLabelElement.getText(), errorMessage)
        );
    }
}
