@smokeTest
@BookingManagement
@BookingPharmacyManagement

#
#
#-------------------------------- TAG: @BookingManagement					--> Estimated Runtime: xx Hour xx minutes
#-------------------------------- TAG: @BookingLocationUser 				--> Estimated Runtime: xx minutes
#-------------------------------- TAG: @BookingItemStockListManagement 		--> Estimated Runtime: xx minutes
#-------------------------------- TAG: @BookingItemCartListManagement 		--> Estimated Runtime: xx minutes
#-------------------------------- TAG: @BookingPharmacyManagement 			--> Estimated Runtime: xx minutes
#
#

Feature: Booking Pharmacy Management

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
    And Message displayed Login Successfully for the user usuario
    When I insert a user location address: Calle Orense, 59 Madrid, España
    And The booking panel will be shown to me

  @BookingPharmacyManagement01
  Scenario: Check that the button to continue with the booking is not available
    When I find the item with the description ESPIDIFEN
    Then The button continue with the booking is not available

  @BookingPharmacyManagement02
  Scenario: Check that the button to continue with the booking is available
    Given I find the item with the description ESPIDIFEN
    When I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    Then The button continue with the booking is available

  @BookingPharmacyManagement03
  Scenario: Check that the button to continue with the booking return to disabled
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    And The button continue with the booking is available
    When I remove all items of the cart
    Then The button continue with the booking is not available

  @BookingPharmacyManagement04
  Scenario: Check that the button to continue with the booking continue to enable
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    And The button continue with the booking is available
    When I remove the ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres item from the cart
    Then The button continue with the booking is available

  @BookingPharmacyManagement05
  Scenario: Verify that, since all items are available in stock, the endBooking option is shown.
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I go to end my booking
    Then The endBooking panel will be shown to me

  @BookingPharmacyManagement06
  Scenario: Verify that, since not all items are available in stock, the endBooking option is not shown.
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 400 mg COMPRIMIDOS RECUBIERTOS , 30 comprimidos to the cart
    When I go to end my booking
    Then The endBooking panel will not be shown to me

  @BookingPharmacyManagement07
  Scenario: Verify that, since all items are available in stock, all items are in the endBooking panel
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I go to end my booking
    Then The endBooking panel will be shown to me
    And I have a total of 1 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE items in the endBooking panel
    And I have a total of 1 ESPIDIFEN 600 MG 40 SOBRES COLA LIMON items in the endBooking panel

  @BookingPharmacyManagement08
  Scenario: Verify that when an item it is deleted from the cart while the summary of the reservation it is show, the item it is eliminated of the summary
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I go to end my booking
    And I remove the ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres item from the cart
    And I have a total of 0 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE items in the endBooking panel

  @BookingPharmacyManagement09
  Scenario: Verify that when an item it is increased from the cart while the summary of the reservation it is show, the item it is increased in the summary
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I go to end my booking
    And I increase 2 items of ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres in the cart
    And I have a total of 3 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE items in the endBooking panel

  @BookingPharmacyManagement10
  Scenario: Verify that when an item it is decreased from the cart while the summary of the reservation it is show, the item it is decreased in the summary
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    And I increase 4 items of ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres in the cart
    When I go to end my booking
    And I decrease 2 items of ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres in the cart
    And I have a total of 3 ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE items in the endBooking panel


  @BookingPharmacyManagement11
  Scenario: verify that the expected pharmacy is the one chosen
    Given I find the item with the description ESPIDIFEN
    And I put the item ESPIDIFEN 600 mg GRANULADO PARA SOLUCION ORAL SABOR ALBARICOQUE, 20 sobres to the cart
    And I put the item ESPIDIFEN 600 MG GRANULADO PARA SOLUCION ORAL SABOR COLA-LIMON , 40 sobres to the cart
    When I go to end my booking
    Then SIXTA CAÑADAS CORREAS is the default pharmacy selected in the endBooking panel
