Feature: Add product to cart

  Scenario: Successful Login and Add Sony Vaio i5 to Cart
     Given User Launch Chrome browser
        When User Opens URL "https://demoblaze.com/index.html"
        When user click on Login option
        And User enters Username as "admin" and Passwod as "admin"
        And click on Login 
        Then Page Title should be "STORE"
    		When User navigates to Laptops category
    		And User selects Product
    		And User clicks on Add to cart button
    		Then A confirmation alert with message "Product added" should appear
    		And close browser