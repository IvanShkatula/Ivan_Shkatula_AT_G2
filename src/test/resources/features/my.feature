Feature: MyFeature

  Background:
    Given I open a site

  Scenario: Compare Filter And Hotel Prices Scenario

    When I type "Париж" as name of the city
    And I open dropdown to add guests
    And I add adult guest
    And I add adult guest
    And I open calendar
    And I choose date which is 2 days later than the current date
    And I choose date which is 7 days later than the current date
    And I tap enter button
    And I filter by highest price
    And I sort low price first
    And I wait until spinner pass
    Then I expect hotel per day price for 5 days will be higher than price in price filter

  Scenario: Change And Compare Colors Scenario
    When I type "Москва" as name of the city
    And I tap enter button
    And I scroll to 10th hotel
    And I change background color to "green" to hotel number 10
    And I change header color to "red" to hotel number 10
    Then I see that header color become red and background color become green in hotel number 10

  Scenario: Availability Of Hotels Scenario
    When I type "москва" as name of the city
    And I open calendar
    And I choose date which is 1 days later than the current date
    And I choose date which is 8 days later than the current date
    And I tap enter button
    Then I see list of Hotels