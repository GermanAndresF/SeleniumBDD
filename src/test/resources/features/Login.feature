Feature: Login

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Login

  @regression
  Scenario Outline: Credenciales erroneas
    When El usuario escriba el username <username> con el password <password> y presione el boton de login
    Then Debe aparecer un mensaje de error indicando <mensajeError>
    Examples:
      | username          | password       | mensajeError                                                                |
      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
      | "hiWorld"         | "hi1234"       | "Epic sadface: Username and password do not match any user in this service" |

  @regression @smoke
  Scenario: Verificar la UI de la pagina login
    Then El usuario verifica que la UI de la pagina de login sea correcta