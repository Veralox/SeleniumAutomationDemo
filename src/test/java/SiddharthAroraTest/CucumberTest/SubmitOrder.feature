Feature: Purchase the order from Ecommerece Website
  i want to use this feature for my feature file

  Background:
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given Logged in with <UserName> and <Password>
    When I add the product <ProductName> to the cart
    And  Checkout <ProductName> and submit the order
    Then Verify the confimation message "THANKYOU FOR THE ORDER." is displayed
    Examples:
      | UserName                | Password           | ProductName |
      |arorasiddharth9@gmail.com|Siddharth@Astha0512 | ZARA COAT 3 |
