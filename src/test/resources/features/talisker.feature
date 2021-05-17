Feature: Talisker

  Scenario: Login

    Given I open "wfrdev3" server with "IvShCucumberTalSP" SP company
    When I enter "SSOUser" username and "Password1!" password
    And I click OK button
    And I switch to frame
    And I open hamburger menu
    And I open dropdown in hamburger menu
    Then I get username