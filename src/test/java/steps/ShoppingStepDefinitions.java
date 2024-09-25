package steps;

import data.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelos.ItemProducto;
import pages.ShoppingPage;
import utilities.CommonFlows;

import java.util.List;

public class ShoppingStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private List<ItemProducto> listaItems;

    @Given("El usuario entra logueado a la pagina de Shopping")
    public void goToShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("El usuario verifica que la UI de la pagina de Shopping sea correcta")
    public void verifyUIShopingPage() {
        shoppingPage.verifyPage();
    }

    @When("Leo los productos esperados de Excel")
    public void readExcelProductList() {
        listaItems = ExcelReader.leerListaItemProductoExcel();
    }

    @Then("Verifico que los productos de Excel coincidan con la pagina")
    public void verifyPrices() {
        shoppingPage.verifyProductsPrice(listaItems);
    }
}
