
@tag
Feature: New Post Creation 
  

  @validPostCreation
  Scenario: New post creation with valid inputs
    Given the user is on the login page
    When user enter the valid username "t1admin" and password "%^&$T1Affnetz#$"
    And click on login button
    When i click create a post 
    Then system should open create post page
    When user give headline "New post Test"
    And select tag name from dropdwon "Free Source"
    And write content details "This post is for testing purpose only"
    And click on post  button
    Then this post should be posted and shown in latest update section with all valid details
    Then i logout
    And close the browser

  
