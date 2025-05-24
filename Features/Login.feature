Feature: Login

Background:
    
    Given User Launch Chrome browser
    When User Opens URL "https://demoblaze.com/index.html"
    When user click on Login option
    
Scenario: Successful Login with Valid Credentials
        
        And User enters Username as "admin" and Passwod as "admin"
        And click on Login 
        Then Page Title should be "STORE"
        When user click on Logout
        And close browser
        
 Scenario Outline: Login Data Driven
 				
        And User enters Username as "<username>" and Passwod as "<password>"
        And click on Login 
        Then Page Title should be "STORE"
        When user click on Logout
        And close browser
        
        Examples:
        
        |username | password |
        | admin | admin |
        | test  | test |