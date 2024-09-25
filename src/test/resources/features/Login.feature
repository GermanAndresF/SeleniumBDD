Feature: Login

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Login

  @regression
  Scenario: Credenciales invalidas
    When El usuario escriba el username "locked_out_user" con el password "secret_sauce" y presione el boton de login
    Then Debe aparecer un mensaje de error indicando "Epic sadface: Sorry, this user has been locked out."

  @regression @smoke
  Scenario: Verificar la UI de la pagina login
    Then El usuario verifica que la UI de la pagina de login sea correcta