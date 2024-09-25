package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.YourInformationPage;
import utilities.CommonFlows;

public class YourInformationStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final YourInformationPage yourInformationPage = new YourInformationPage();

    @Given("El usuario navega a la pagina de Your Information")
    public void goToYourInformationPage() {
        commonFlows.goToYourInformationPage();
    }

    @When("El usuario escriba el nombre {string}, el apellido {string}, el zipcode {string} y presione continue")
    public void fillUserInfo(String name, String lastname, String zipcode) {
        yourInformationPage.fillData(name, lastname, zipcode);
    }

    @Then("Debe aparecer el mensaje de error {string}")
    public void verifyErrorMessage(String errorMessage) {
        yourInformationPage.verifyErrorMessage(errorMessage);
    }
}
