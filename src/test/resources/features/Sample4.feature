@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table

  Background:
    Given I am on age page feedback

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 1 |
      | Option 3 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 1, Option 3" is seen

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 2 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 2" is seen
    # TODO - Add implementation for missing steps
  @test
  Scenario: Feedback with only languages
#    Given I am on age page feedback
    When I select feedback age languages
      | English |
      | Spanish |
    And I click send feedback age
    Then I can see languages "English,Spanish" in feedback check


 # TODO - create Scenario Outline for 'Give us your feedback!' page
  # URL: https://kristinek.github.io/site/tasks/provide_feedback
  # Navigate to page
  # Set Name, Age and Genre
  # - All input MUST be done in single step
  # - All input MUST use Examples for data
  # - Step can use Map or Domain object
  # Click "Send" button and verify that previous input is displayed in correct fields