Feature: Shopping

  Background: Precondicion del feature
    Given El usuario entra logueado a la pagina de Shopping

  @regression @smoke
  Scenario: Verificar la UI de Shopping
    Then El usuario verifica que la UI de la pagina de Shopping sea correcta

  @regression
  Scenario: Verificar precios
    When Leo los productos esperados de Excel
    Then Verifico que los productos de Excel coincidan con la pagina