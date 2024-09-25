package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MenuBurger;
import utilities.CommonFlows;

public class BurgerMenuStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final MenuBurger menuBurger = new MenuBurger();
    private final LoginPage loginPage = new LoginPage();

    @Given("El usuario entra logueado y abre el burger menu")
    public void openBurgerMenu() {
        commonFlows.openBurgerMenu();
    }

    @When("El usuario hace click en la opcion de logout")
    public void clickLogoutOption() {
        menuBurger.clickLogout();
    }

    @Then("La aplicacion redirige a la pagina de login")
    public void verifyLoginPage() {
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Then("El usuario verifica que la opcion de About tenga el link {string}")
    public void verifyAboutLink(String url) {
        menuBurger.verifyAboutLink(url);
    }
}
