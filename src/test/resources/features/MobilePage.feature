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
    Then the item order is <firstItem>, <middleItem>, <lastItem>

    Examples: 
      | sortBy     | firstItem     | middleItem       | lastItem         |
      | "Name"     | "IPHONE"      | "SAMSUNG GALAXY" | "SONY XPERIA"    |
      | "Price"    | "SONY XPERIA" | "SAMSUNG GALAXY" | "IPHONE"         |
      | "Position" | "SONY XPERIA" | "IPHONE"         | "SAMSUNG GALAXY" |

  @Mobile-Verify-Price
  Scenario Outline: Verify Mobile Page Price Matches Details Page Price
    Given I open the details page for <device>
    Then the <mobilePagePrice> matches the price on the details page

    Examples: 
      | device           | mobilePagePrice |
      | "SONY XPERIA"    | "$100.00"       |
      | "IPHONE"         | "$500.00"       |
      | "SAMSUNG GALAXY" | "$130.00"       |

  @Mobile-Compare
  Scenario: Compare devices
    Given I select to compare "Sony Xperia" and "iPhone"
    Then a popup window displays that has a heading of "COMPARE PRODUCTS"
    And the popup window displays "Sony Xperia" and "IPhone"
