
Feature: Public Donation
  

  @tag1
  Scenario: Check public donation with valid inputs
    Given the user is open public donation page
    Then the use should re-direct to public donation page
    When i give user details "Aleka" "pradhan" "7873530919" "engineering+sept12@affnetz.com"
    And i give donation amount "250"
    And i give user address details "New Test Add" "New Test City" "Baker Island" "88888"
    And i give payment details "4242 4242 4242 4242" "4242" "444" "88888"
    When i click donate button
    Then the form should submit and show cofirm message and user should download the receipt
    Then the donor name should display to admin
    

 