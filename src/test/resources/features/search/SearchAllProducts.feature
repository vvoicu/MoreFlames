@Search
Feature: Check search feature
  Grab all search result items
  
   Scenario: Searching for a designer
    Given the user is in home page
    When searches for 'GUCCI' in 'women' section
	Then all the products are displayed
	