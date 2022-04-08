Feature: Checking all numbers


  Background:
    Given I am on age page error cases
  Scenario:

    When I enter number correct case simple : "64"
    And  I click submit correct cases
    Then I see message correct cases:"Square root of 64 is 8.00"


   @checkcorrectnumbers
Scenario Outline: to put correct numbers

  When I enter number correct case: <number>
  And I click submit correct cases
  Then I see message correct cases:"<message>"
  Examples:
  | number|         message                 |
  | 70    |   Square root of 70 is 8.37     |
  | 50    |   Square root of 50 is 7.07     |
  | 64    |   Square root of 64 is 8.00     |
@checkincorectnumbers
  Scenario Outline: to put incorect number

    When  I enter number error case: "<number>"
    And   I click submit error cases
    Then  I see message error cases: <message>
    Examples:
      | number |         message           |
      |    5   |    "Number is too small"    |
      |   102  |    "Number is too big"      |
      |   str  |    "Please enter a number"  |
