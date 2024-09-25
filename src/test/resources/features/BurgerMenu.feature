Feature: Burger Menu

  Background: Precondicion del feature
    Given El usuario entra logueado y abre el burger menu

  @regression @smoke
  Scenario: Logout
    When El usuario hace click en la opcion de logout
    Then La aplicacion redirige a la pagina de login

  @regression
  Scenario: About
    Then El usuario verifica que la opcion de About tenga el link "https://saucelabs.com/"