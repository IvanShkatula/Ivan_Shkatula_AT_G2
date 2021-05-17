Feature: jotfrom

  Background:
    Given I open jotform.com site

  Scenario: Create classic form

    When I login with "iwan_shkatula" username and "Password1!" password
    And I'm waiting for the page to load
    And I click 'Create new Form' button
    And I choose 'Start From Scratch'
    And I choose 'Classic Form'
    And I set "test form" form name
    And I open list of elements
    And I add Header element
    And I set "header1" header name
    And I add Full name element
    And I save new form
    And I open jotform.com site
    Then I look if new form has been created
    And I delete form

  Scenario: Create card form
    When I login with "iwan_shkatula" username and "Password1!" password
    And I'm waiting for the page to load
    And I click 'Create new Form' button
    And I choose 'Start From Scratch'
    And I choose 'Card Form'
    And I wait 'add header element'
    And I open jotform.com site
    Then I look if new form has been created
    And I delete form