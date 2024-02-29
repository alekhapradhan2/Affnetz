
Feature: User Login
    @ValidLogin
    Scenario: Successful login with valid credentials
    Given the user is on the login page at "https://t1.affnetz.org/login"
    When the user enters a valid username "t1admin"
    And the user enters a valid password "%^&$T1Affnetz#$"
    And clicks on the login button
    Then the user should be logged in successfully
    When i click on logout button
    Then the user should logged out
    Then i close the browser
 		
 		@invalidLogin
 		Scenario Outline: Unsuccessful login with invalid credentials
		Given the user is on the login page at "https://t1.affnetz.org/login"
    When the user enters a invalid username "<uname>"
    And the user enters a invalid password "<pwd>"
    And clicks on the login button
    Then the system should show error message to user
    Then i close the browser
    
    Examples:
		|uname|pwd|
		|t1admin|ghhgdh|
		|hgch|%^&$T1Affnetz#$|
 