Feature: Error validation on Ecommerece Website
  i want to use this feature for website error validation

  @ErrorValidation
  Scenario Outline: Comfiming message is displayed when login with invalid username or password
    Given I landed on Ecommerce Page
    When Logged in with <UserName> and <Password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | UserName                 | Password |
      |arorasiddharth9@gmail.com |Astha0512 |