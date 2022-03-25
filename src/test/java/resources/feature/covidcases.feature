Feature: Covid Data
Checking the functionality of retrieving covid cases data

@Regression
 Scenario: As a user, I want to check total cases of covid for UK
  When user creates a get request by entering the Country Name as "UK"
   Then user should be able to see the total cases of covid for UK
   And user verifies that the country is "UK"

