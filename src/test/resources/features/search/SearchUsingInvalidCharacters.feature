@Search
Feature: Check search feature
  In order to check the search feature
  As a user
  I want to search using invalid characters
  
  Scenario: Searching using invalid characters
    Given the user is in home page
    When searches for '#' in 'women' section
	Then an error message containing '#' is displayed