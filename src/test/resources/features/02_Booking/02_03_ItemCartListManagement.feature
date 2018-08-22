@smokeTest
@Booking
@BookingCartItemListManagement
Feature: Booking Item Stock List Management

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
    And Message displayed Login Successfully for the user usuario
    When I insert a user location address: Calle Orense, 59 Madrid, España
    And The booking panel will be shown to me

  @BookingCartItemListManagement01
  Scenario: Successful add a item to cart
    Given My cart have 0 items added
    When I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Then My cart have 1 items added
    And The button continue with the booking is available

  @BookingCartItemListManagement02
  Scenario: Consul the cart
    Given The cart panel is not available
    When I consult my current cart
    Then The cart panel is available
    When I hide my current cart
    Then The cart panel is not available


  @BookingCartItemListManagement03
  Scenario: Consul that the item added are in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I consult my current cart
    Then The ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres item is in the cart
    And I have a total of 1 ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres items in my cart

  @BookingCartItemListManagement04
  Scenario: Add and consul that two items added are in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Given I find the item with the description SERUM
    And I put the item +BUST SERUM 100 ML to the cart
    When I consult my current cart
    Then The ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres item is in the cart
    And The +BUST SERUM 100 ML item is in the cart

  @BookingCartItemListManagement05
  Scenario: Add two items in the cart and add more of one of them
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Given I find the item with the description SERUM
    And I put the item +BUST SERUM 100 ML to the cart
    When I consult my current cart
    And I add 5 items of +BUST SERUM 100 ML in the booking
    Then I have a total of 6 +BUST SERUM 100 ML items in my cart

  @BookingCartItemListManagement06
  Scenario: Add two items in the cart, add and rest of one of them
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Given I find the item with the description SERUM
    And I put the item +BUST SERUM 100 ML to the cart
    When I consult my current cart
    And I add 5 items of +BUST SERUM 100 ML in the booking
    And I rest 4 items of +BUST SERUM 100 ML in the booking
    Then I have a total of 2 +BUST SERUM 100 ML items in my cart

  @BookingCartItemListManagement07
  Scenario: Remove a item in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 400 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA , 30 sobres to the cart
    When I consult my current cart
    And I remove the ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres item from the booking
    Then I have a total of 0 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres items in my cart
    And My cart have 2 items added

  @BookingCartItemListManagement08
  Scenario: Remove all items in the cart
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 400 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA , 30 sobres to the cart
    When I consult my current cart
    And I remove all items of the booking
    Then I have a total of 0 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres items in my cart
    And My cart have 0 items added