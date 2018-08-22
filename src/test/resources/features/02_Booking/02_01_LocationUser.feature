@smokeTest
@Booking
@BookingLocationUser
Feature: Booking Location User

  Background: Generic Steps

    Given User Navigate to Home Page
    Given I tried to login with usuario and Luda2017
    And Message displayed Login Successfully for the user usuario

  @BookingLocationUser01
  Scenario: Successful location user
    Given The booking panel not will be shown to me
    And The user location address for the booking is: defaultValue
    When I insert a user location address: Calle Orense, 59 Madrid, España
    Then The booking panel will be shown to me
    And The user location address for the booking is: Calle Orense, 59 Madrid, España