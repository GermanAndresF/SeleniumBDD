package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class MenuBurger extends BasePage {
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");

    @Override
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getSimpleName());

        Logs.info("Esperando que sea clickeable por la animacion");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el menu burger");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(logoutButton).isDisplayed()),
                () -> Assertions.assertTrue(find(aboutButton).isDisplayed())
        );
    }

    public void clickLogout() {
        Logs.info("Haciendo click en logout");
        find(logoutButton).click();
    }

    public void verifyAboutLink(String expectedUrl) {
        final var aboutLabel = find(aboutButton);

        Logs.info("Verificando la opcion de about");
        Assertions.assertAll(
                () -> Assertions.assertTrue(aboutLabel.isDisplayed()),
                () -> Assertions.assertTrue(aboutLabel.isEnabled()),
                () -> Assertions.assertEquals(
                        aboutLabel.getAttribute("href"),
                        expectedUrl
                )
        );
    }
}
