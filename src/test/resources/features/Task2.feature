Feature: Check People with jobs

#  Background:
#    Given I am on People with jobs

      Scenario Outline:
        Given I am on People with jobs
        When I press add person
        And I put in Name "<name>"
        And  I put in Surname "<surname>"
        And I put in Job "<job>"
        And I put in Dateofbirth "<dob>"
        And I put in Gender "<gender>"
        And I put in language "<language>"
        And I put in Emplyeestatus "<employee>"
        Then I click Add
        Examples:
        |name|surname|job|dob|gender|language|employee|
        |Aleks|Ivanov|Welder|22072000|female|spanish|intern|
        |Aleks|Zukov|Welder|22072000|female|spanish|employee|


  Scenario:
#    When I go to Edit Person
#    And I change Name
#    |name1|Mike|
#    |name    | Vasja     |
#    And I change job
#    And I press edit
#    Then I see changes

   Scenario:Remove Person Mike
     Given I am on People with jobs
    When I Remove Person Mike
    Then I dont see Mike

  Scenario:Edit Person Mike
    Given I am on People with jobs
    When I press edit Mike
    And  I change name Mike to "Noland"
    And  I click Edit Mike
    Then I see changed Mike name"Noland"

