Feature: Footer

  Background: Precondicion del feature
    Given El usuario entra logueado a la pagina de Shopping

  @regression
  Scenario: Verificar las redes sociales del footer
    Then El usuario verifica que los links sean correctos "https://twitter.com/saucelabs", "https://www.linkedin.com/company/sauce-labs/", "https://www.facebook.com/saucelabs"