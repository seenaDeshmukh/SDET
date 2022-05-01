@All
Feature: Coupen feature
  
  Background: User is logged In
	Given User navigate to the login page
	When User submit username and password
	Then User should be logged in 

  Scenario: Create Coupon
    Given User navigates to the coupon page
    When User creates a coupon  
    Then User verify that the coupon is created
    
  Scenario: Update Coupen
    Given User navigates to the coupon page
    When User updating the coupon details
    Then User verify that the coupon is updated
   
  Scenario: Delete Coupon    
    Given User navigates to the coupon page
    When User deleting the coupon details
    Then User verify that the coupon is deleted