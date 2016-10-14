@Search 
Feature: Search for a product
	In order to find products easily
  	As a user
  	I want to Filter search by Category
	
Scenario Outline: Search for product 
	Given the user is in home page 
	When searches for '<product>' in 'women' section 
	Then verify item category in product details list page: '<product_details>'
	
	
	
	Examples:
	|product| |product_details|
	|bag    | |bag             |