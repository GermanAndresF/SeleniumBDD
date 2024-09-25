package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ShoppingPage;
import utilities.CommonFlows;

public class ShoppingStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @Given("El usuario entra logueado a la pagina de Shopping")
    public void goToShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("El usuario verifica que la UI de la pagina de Shopping sea correcta")
    public void verifyUIShopingPage() {
        shoppingPage.verifyPage();
    }
}
