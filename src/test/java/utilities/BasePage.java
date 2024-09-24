package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final static int defaultTimeout = 5;
    private final int timeout;

    public BasePage(int timeout) {
        this.timeout = timeout;
    }

    public BasePage() {
        this(defaultTimeout); //llamo al constructor de arriba con el default timeout
    }

    protected WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    protected void waitPage(By locator, String pageName) {
        final var wait =
                new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeout));

        Logs.info("Esperando que la pagina %s cargue", pageName);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        Logs.info("%s ha cargado satisfactoriamente", pageName);
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public abstract void waitPageToLoad(); //esperar que cargue la pagina

    public abstract void verifyPage(); //verificar la UI de la pagina

}
