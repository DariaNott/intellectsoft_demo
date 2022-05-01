Feature: Just for reporting show purposes

  @reporting_demo
  Scenario: Successful should pass
    Given I open planetakino.ua Main page
    When I login as a valid user
    Then user authorization status should be "authorised"

  @reporting_demo
  Scenario: Scenario that fails
    Given I open planetakino.ua Main page
    When I login as a valid user
    Then user authorization status should be "FAILED"

  @reporting_demo
  Scenario: Scenario with non-existing step
    Given I open planetakino.ua Main page
    When I login as a valid user
    #the issue here is that 'a' character is written with ukrainian keyboard
    Then user аuthorization status should be "FAILED"

