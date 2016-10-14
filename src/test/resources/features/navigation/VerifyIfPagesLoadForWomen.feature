Feature: Check if page loads
  In order to verify the navigation feature
  As a user
  I want to navigate through the entire menu of women section
  
  Scenario Outline: Navigate through the entire menu
    Given the user is in home page
    And select the 'women' option
    And click the items
	| JUST IN		    |just-in/just-in-this-month  |
	| SHOP          	|shop     					 |
	| DESIGNERS         |designers                   |
	| THE STYLE REPORT  |the-style-report            |
	| SHOP BY           |shop-by                     |
	| STUDIOS           |studios-landing             |
	| SALE              |sale                        |
	And select the 'women' option
	Then the URL page should contain the '<menu_option>'
	Examples:
	| menu_option   	|
	| JUST IN		    | 