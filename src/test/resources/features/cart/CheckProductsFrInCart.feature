@Fashion
Feature: Check products in cart
  In order to buy products
  As a user
  I want to add products in the cart and go to checkout

  Scenario: User adds products in cart and goes to checkout
    Given the user is in home page
    And searches for 'shirt' in 'women' section
    And selects the product 'shirt'
    And adds to cart '2' products of size '36 FR'
    And searches for 'scarf' in 'women' section
    And selects the product 'scarf'
    And adds to cart '2' products of size 'ONE SIZE'
    When the user goes to cart
    Then the products should be correctly displayed
    And the totals should be correctly calculated