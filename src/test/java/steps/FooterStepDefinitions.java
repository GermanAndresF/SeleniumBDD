package steps;

import io.cucumber.java.en.Then;
import pages.Footer;

public class FooterStepDefinitions {
    private final Footer footer = new Footer();

    @Then("El usuario verifica que los links sean correctos {string}, {string}, {string}")
    public void verifySocialMediaLinks(String twitterUrl, String linkedinUrl, String facebookUrl) {
        footer.verifySocialMediaLinks(twitterUrl, linkedinUrl, facebookUrl);
    }
}
