Feature: Item Detail

  Background: Precondicion del feature
    Given El usuario va al detalle del item llamado "Sauce Labs Fleece Jacket"

  @regression @smoke
  Scenario: Verificar la UI del detalle
    Then El usuario verifica que la UI de la pagina del detalle de un item sea correcta

  @regression
  Scenario: Regresar pagina shopping
    When El usuario hace click en el boton Back to Products
    Then La aplicacion redirige a la pagina de Shopping