package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import utilities.CommonFlows;

public class ItemDetailStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();


    @Given("El usuario va al detalle del item llamado {string}")
    public void goToItemDetail(String itemName) {
        commonFlows.goToItemDetail(itemName);
    }

    @Then("El usuario verifica que la UI de la pagina del detalle de un item sea correcta")
    public void verifyItemDetailUI() {
        itemDetailPage.verifyPage();
    }

    @When("El usuario hace click en el boton Back to Products")
    public void clickBackToProducts() {
        itemDetailPage.clickBackToProducts();
    }

    @Then("La aplicacion redirige a la pagina de Shopping")
    public void goBackToShoppingPage() {
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
