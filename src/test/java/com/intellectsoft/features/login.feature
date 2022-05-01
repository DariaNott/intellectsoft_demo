Feature: Basic login functionality
  Narrative: As a user, I want to be able to login so that I can receive personal benefits from planetakino usage

  @smoke
  Scenario: Sign in with invalid credentials
    Given I open planetakino.ua Main page
    When I login with user name "someone" and password "somepassword"
    Then user authorization status should be "anonymous"

  @smoke
  Scenario: Successful sign in
    Given I open planetakino.ua Main page
    When I login as a valid user
    Then user authorization status should be "authorised"