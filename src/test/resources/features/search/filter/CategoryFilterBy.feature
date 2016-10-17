@Search 
Feature: Search for a product
	In order to find products easily
  	As a user
  	I want to Filter search by Category
	
Scenario Outline: Search for product 
	Given the user is in home page 
	When searches for '<product>' in 'women' section 
	Then the items details in product list page is: '<product_details>'
	When picks a category in Filter By Category list: '<category_name>'
	Then the items displayed are having details populated with '<category_name>'
	When picks a second category in Filter Category list: '<category_name2>'
	Then the items displayed are having details populated with '<product_details>'
	
	
	
	
	Examples:
	|product|product_details|category_name|category_name2   |
	|bag    |bag            |Accessories	|Bag Accessories|
	