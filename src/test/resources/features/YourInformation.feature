Feature: Your Information

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Your Information

  @regression
  Scenario Outline: Mensajes de error
    When El usuario escriba el nombre <nombre>, el apellido <apellido>, el zipcode <zipcode> y presione continue
    Then Debe aparecer el mensaje de error <mensajeError>
    Examples:
      | nombre   | apellido   | zipcode      | mensajeError                     |
      | ""       | "Apellido" | "Zipcode123" | "Error: First Name is required"  |
      | "Nombre" | ""         | "Zipcode123" | "Error: Last Name is required"   |
      | "Nombre" | "Apellido" | ""           | "Error: Postal Code is required" |