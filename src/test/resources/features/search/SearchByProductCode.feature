@Search
Feature: Search for a product code
  Grab all search result items
  
  Scenario Outline: Search for a product code
	Given the user is in home page
    When searches for '<product_code>' in 'men' section
	Then the displayed product should have code: '<product_code>', title: '<product_title>', details: '<product_details>', price '<product_price>'
	
	Examples:
	|product_code  |product_title		|product_details 						   |product_price |
	|1060993       |OFF-WHITE           |Perforated low-top nubuck-leather trainers|398		      |
	|1061284 	   |HAIDER ACKERMANN    |Fugazi ribbed-jersey roll-neck sweater    |406		      |
	|1062134	   |John Varvatos	    |Crew-neck abstract sweater				   |438			  |		
	|1055139       |Moncler             |Dupress quilted-down gilet                |500           |	