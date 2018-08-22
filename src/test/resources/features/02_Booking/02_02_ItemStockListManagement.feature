@smokeTest
@Booking
@BookingStockItemListManagement
Feature: Booking Item Stock List Management

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
    And Message displayed Login Successfully for the user usuario
    When I insert a user location address: Calle Orense, 59 Madrid, España
    And The booking panel will be shown to me

  @BookingStockItemListManagement01
  Scenario: Successful item found
    When I find the item with the description ESPIDIFEN 400 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA , 30 sobres
    Then The list of found items is shown in the booking panel
    And The button continue with the booking is not available

  @BookingStockItemListManagement02
  Scenario: Successful add the first item to cart
    Given My cart have 0 items added
    When I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 400 mg GRANULADO PARA SOLUCION ORAL SABOR MENTA , 30 sobres to the cart
    Then My cart have 1 items added
    And The button continue with the booking is available

  @BookingStockItemListManagement03
  Scenario: Successful add a item to cart
    Given My cart have 0 items added
    When I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Then My cart have 1 items added
    And The button continue with the booking is available

  @BookingStockItemListManagement04
  Scenario: Successful add the last item to cart
    Given My cart have 0 items added
    When I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    Then My cart have 1 items added
    And The button continue with the booking is available

  @BookingStockItemListManagement04
  Scenario: Successful add more item to cart
    Given My cart have 0 items added
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    When I find the item with the description SERUM
    And I put the item +BUST SERUM 100 ML to the cart
    Then My cart have 2 items added
    And The button continue with the booking is available