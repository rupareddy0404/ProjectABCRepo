
Feature: Title of your feature
  I want to use this template for my feature file

@regression
   Scenario Outline: To Validate that user is able to login with multiple login details
   Given user is on login page
   When user enters valid username"<username>"
   And user enters valid password"<password>"
   And clicks on submit


 Examples: 
      | username  | password |
      | Testing1@gmail.com |P12222 |
      | Selenium1@gmail.com |P13333 |
