Feature: Security checks
  Narrative: As admin I want to be sure that nobody can get illegal access to my account

  @security_check
  Scenario Outline: Check weak passwords
    Given I open planetakino.ua Main page
    When I login with user name "<user>" and password "<password>"
    Then user authorization status should be "anonymous"

    Examples:
      | user        | password    |
      | admin       | admin       |
      | admin       | password    |
      | admin       | planetakino |