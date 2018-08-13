@smokeTest
@happyPaths
@happyPathReservation
Feature: Happy Path Reservation

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
   # And Message displayed Login Successfully for the user usuario
    When I insert a user location address: Calle Maudres, 26 Madrid, España
    #And the booking panel will be shown to me

  @happyPathReservation01
  Scenario: Successful item found

    When I find the item with the description ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres
    Then the list of found items is shown

  @happyPathReservation02
  Scenario: Successful add a item to cart

    Given I find the item with the description ESPIDIFEN
   # And the list of found items is shown
    When I add the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres to the cart
    #When I add the item CAFIASPIRINA 500 mg/50 mg COMPRIMIDOS , 20 comprimidos to the cart
    Then the popup of element added to the cart is shown