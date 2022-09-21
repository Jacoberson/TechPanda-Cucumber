@CartPage
Feature: Cart Page

  Background: 
    Given I have a "Sony Xperia" in my cart

  @Mobile-Verify-Max-Quantity
  Scenario: Verify Max Quantity
    Given I change the quantity to "1000"
    Then I get an error message

  @Mobile-Verify-Empty-Cart
  Scenario: Verify Cart Can Be Emptied
    Given I click the empty cart button
    Then my shopping cart is empty
