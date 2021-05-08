Feature: MyApiFeature

  Scenario: Search User by not full name

    Given I send Post response with "bert" username
    When I get response
    And I want to compare it with User number 1
    Then I expect they are similar