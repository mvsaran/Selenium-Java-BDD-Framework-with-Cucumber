Feature: Cart Checkout

  Scenario: Successful Login and Add Sony Vaio i5 to Cart
    	  Given Browser is initialized
        When user click on Login option
        When User logs in using credentials from config
        And click on Login 
        Then Page Title should be "STORE"
    		When User navigates to Laptops category
    		And User selects Product
    		And User clicks on Add to cart button
    		Then A confirmation alert with message "Product added" should appear
    		When User clicks on Cart
   		  Then The product "Sony vaio i5" should be visible in the cart
   		  When I clear the cart if more than one product added
   		  And User clicks on Place Order button
		    When User fills the order form with dynamic random values
    		And User clicks on Purchase button
		    Then Success message "Thank you for your purchase!" should be displayed
    		And User clicks OK on the success alert
    		And close browser