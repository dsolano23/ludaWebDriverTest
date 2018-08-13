@smokeTest
Feature: Create User

  @createFinalUser
  Scenario Outline: Check submit button Create Final User
    Given User Navigate to Home Page
    And User Navigate to CreateFinalUser Page
    Then The look and feel of the page Create User is correct
    When I filled the form with the data idUsername: <idUserName>, email: <email>, password: <password>, confirmPWD: <confirmPWD>, name: <name>, surname: <surName>, age: <age>, phone: <phone>
    Then The create user button <available> available

    Examples:
      | idUserName       | email                      | password | confirmPWD | name | surName      | age | phone     | available |
      | qa01ludapartners | qa01ludapartners@gmail.com | Luda2017 | Luda2017   | qaUno | ludapartners | 16  | 666555111 |     is     |