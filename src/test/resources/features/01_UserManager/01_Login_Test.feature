@login
Feature: Login Action

  Background: Generic Steps

    Given User Navigate to Home Page
    #When User Navigate to LogIn Page

  Scenario Outline: Successful Login with Valid Credentials

    When I tried to login with <UserName> and <Password>
    Then Message displayed Login Successfully for the user <UserName>

    Examples:
      | UserName    | Password |
      | usuario     | Luda2017 |
      | farmacia    | Luda2017 |
      | laboratorio | Luda2017 |

  Scenario Outline: Successful Login with invalid Credentials

    When I tried to login with <UserName> and <Password>
    Then Message displayed Login unsuccessfully

  Examples:
  | UserName    | Password |
  | usuario     | Luda2018 |
  | farmacia    | Luda2018 |
  | laboratorio | Luda2018 |

