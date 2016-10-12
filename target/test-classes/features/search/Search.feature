@Search
Feature: Check search feature
  In order to check the search feature
  As a user
  I want to search for different terms 

  Scenario: Searching for a designer
    Given the user is in home page
    When searches for 'GUCCI' in 'women' section
	Then all the products displayed should be from 'GUCCI'
	
  Scenario Outline: Searching for a product code
    Given the user is in home page
    When searches for '<product_code>' in 'women' section
	Then the displayed product code should be '<expected_product_code>'
	Examples:
	| product_code 	| expected_product_code |
	| 1059773 		| 1048129 |
	| 1048129 		| 1048129 |