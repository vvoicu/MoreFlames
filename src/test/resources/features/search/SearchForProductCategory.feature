@Search
Feature: Check search feature
  In order to check the search feature
  As a user
  I want to search for different category
  
   Scenario Outline: Searching for a product category
    Given the user is in home page
    When searches for '<product_cadegory>' in 'women' section
	Then the displayed products details should contain the '<product_cadegory>'
	Examples:
	| product_cadegory 	|
	| dress		        | 
	| bags          	| 
	| backpacks         |
	