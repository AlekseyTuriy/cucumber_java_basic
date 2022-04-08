@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 2 column tables

  Background:
    Given I am on age page feedback

#  Scenario: a new scenario with 2-column table
When I enter values:
     | name | Ann |
      | age  | 5   |
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: another new scenario with 2-column table
    When I enter values:
      | name | Bob |
      | age  | 61  |
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  Scenario Outline: a new scenario outline 2
    When I enter values:
      | name | <name> |
      | age  | <age>  |
    And I click submit age
    Then I see message: "<message>"
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |

#  TODO - create Scenario Outline for 'Give us your feedback!' page
  # URL: https://kristinek.github.io/site/tasks/provide_feedback
  # Navigate to page
  Scenario:
   # Set Name, Age and Genre
    Given I am on age page feedback
    When I set Name Age Genre as table:
  # - All input MUST be done in single step
      | name  | age   |genre|
      |  Aleks  |   15    |male|

  # - All input MUST use Examples for data
  # - Step can use Map or Domain object
     And I click submit feedback page
  # Click "Send" button and verify that previous input is displayed in correct fields
     Then I see correct name:"Aleks"
     And I see correct age:"15"
     And I see correct genre:"male"

  Scenario Outline:
#    Set Name, Age and Genre
    Given I am on age page feedback
    When I set Name Age Genre:
#   - All input MUST be done in single step
      | name| <name>|
      |   age|   <age>  |
      |     genre | <genre>      |
#   - All input MUST use Examples for data
#   - Step can use Map or Domain object
    And I click submit feedback page
  # Click "Send" button and verify that previous input is displayed in correct fields
    Then I see correct name:"<name>"
    And I see correct age:"<age>"
    And I see correct genre:"<genre>"
    Examples:
    |name|age|genre|
    | Aleks    | 15  | male    |
    |  Sveta        |  20   |female|

