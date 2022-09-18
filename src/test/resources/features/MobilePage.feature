@Mobile
Feature: Mobile Page

	Background:
	Given I am on the mobile page
	
	@Mobile-Title
	Scenario: Verify Mobile Page Title
	Given the header displays "MOBILE"
	Then the title of the page is "Mobile"
	
	
  @Mobile-Sort
  Scenario Outline: Sort Items on Mobile Page
    Given I sort the items by <sortBy>
    Then the first item is <firstItem>
    And the middle item is <middleItem>
    And the last item is <lastItem>

    Examples: 
      | sortBy  | firstItem | middleItem  | lastItem |
      | "Name" | "IPHONE" | "SAMSUNG GALAXY" | "SONY XPERIA" |
      | "Price" | "SONY XPERIA" | "SAMSUNG GALAXY" | "IPHONE" |
      | "Position" | "SONY XPERIA" | "IPHONE"| "SAMSUNG GALAXY" |
