@happyPaths
@happyPathReservation
Feature: Happy Path Reservation

  Background: Generic Steps

    Given User Navigate to Home Page


  Scenario: Successful user location

    Given I tried to login with usuario and Luda2017
     And Message displayed Login Successfully for the user usuario
    When I insert a user location address: calle maudres, 26 madrid, España



