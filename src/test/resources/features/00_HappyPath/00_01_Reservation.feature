@smokeTest
@happyPaths
@happyPathReservation
Feature: Happy Path Reservation

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
    And Message displayed Login Successfully for the user usuario
    #When I insert a user location address: Calle Maudes, 26 Madrid, España
    When I insert a user location address: Calle Orense, 59 Madrid, España
    And The booking panel will be shown to me

  @happyPathReservation01
  Scenario: Successful item found
  #When I insert a user location address: Calle Estrella, Palomares del Campo
    #Given The list of found items is not shown in the booking panel
    When I find the item with the description ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres
    Then The list of found items is shown in the booking panel
    And The button continue with the booking is not available

  @happyPathReservation02
  Scenario: Successful add a item to cart

    Given My cart have 0 items added
    When I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres to the cart
    Then My cart have 1 items added

  @happyPathReservation03
  Scenario: Consul the cart
    Given The cart panel is not available
    When I consult my current cart
    Then The cart panel is available
    When I hide my current cart
    Then The cart panel is not available

  @happyPathReservation04
  Scenario: Consul that the item added are in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 20 sobres to the cart
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sob to the cart
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    When I consult my current cart
    Then The ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE item is in the cart
    And The ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres item is not in the cart
  #When I add the item CAFIASPIRINA 500 mg/50 mg COMPRIMIDOS , 20 comprimidos to the cart
  #Then the popup of element added to the cart is shown

  @happyPathReservation05
  Scenario: Add more item in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 20 sobres to the cart
    When I consult my current cart
    And I increase 5 items of ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE in the cart
    Then I have a total of 6 ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE items in my cart

  @happyPathReservation06
  Scenario: Rest items in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 20 sobres to the cart
    When I consult my current cart
    And I increase 5 items of ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE in the cart
    And I decrease 4 items of ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE in the cart
    Then I have a total of 2 ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE items in my cart

  @happyPathReservation07
  Scenario: Remove items in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 20 sobres to the cart
    When I consult my current cart
    And I remove the ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE item from the cart
    Then I have a total of 0 ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE items in my cart
    And My cart have 2 items added

  @happyPathReservation08
  Scenario: Remove all items in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 20 sobres to the cart
    When I consult my current cart
    And I remove the ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE item from the cart
    And I remove the ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS item from the cart
    And I remove the ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON item from the cart
    Then I have a total of 0 ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE items in my cart
    And My cart have 0 items added

  @happyPathReservation09
  Scenario: Check that the button to continue with the booking is enabled
    Given I find the item with the description ESPIDIFEN
    When I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    Then The button continue with the booking is available

  @happyPathReservation10
  Scenario: Check that the button to continue with the booking return to disabled
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And The button continue with the booking is available
    When I consult my current cart
    And I remove the ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE item from the cart
    And The button continue with the booking is not available

  @happyPathReservation11
  Scenario: Check that the button to continue with the booking continue to enable
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 40 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    And The button continue with the booking is available
    When I consult my current cart
    And I remove the ESPIDIFEN 600 MG 40 SOBRES ALBARICOQUE item from the cart
    And The button continue with the booking is available

  @happyPathReservation12
  Scenario: The items of the cart go to finalize reservation

    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres to the cart
    When I consult my current cart
    And I increase 5 items of ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA EFG, 20 sobres in the cart
    When I hide my current cart
    Given I find the item with the description BUST
    And I put the item +BUST SERUM 100 ML to the cart
    And The button continue with the booking is available
    When I go to end my booking
    Then The endBooking panel will be shown to me
    And I have a total of 6 ESPIDIFEN 600 MG 20 SOBRES MENTA EFG items in the endBooking panel
    #When I select the change pharmacy option in the endBooking panel
    #When I select the come back option in the endBooking panel
    #When I select the new booking option in the endBooking panel
    #And The booking panel will be shown to me


    #Then I have a total of 0 +BUST SERUM 100 ML item in the endBooking panel