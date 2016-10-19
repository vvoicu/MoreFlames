Feature: Check if page loads
  In order to verify the navigation feature
  As a user
  I want to navigate through the entire menu of women section
  
  Scenario: Navigate through the entire menu
    Given the user is in home page
    And select the 'women' option
    And click the items and verify the pageUrls
	| JUST IN		    |womens/just-in/just-in-this-month|
	| SHOP          	|womens/shop				      |
	| DESIGNERS         |intl/designers                   |  
	| THE STYLE REPORT  |womens/the-style-report          |
	| SHOP BY           |womens/shop-by                   |
	| STUDIOS           |womens/studios-landing           |
	| SALE              |womens/sale                      |
	And select the 'men' option
	Then click the items and verify the pageUrls
	| JUST IN		    |mens/just-in/just-in-this-month|
	| SHOP          	|mens/shop				        |
	| DESIGNERS         |intl/designers                 |  
	| THE STYLE REPORT  |mens/the-style-report          |
	| STUDIOS           |mens/studios-landing           |
	| SALE              |mens/sale                      |