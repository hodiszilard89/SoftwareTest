Feature: Spotify sing up page

  Background:
    Given the home page is opened
    Then the cookie distance is closed
    And click About button

  Scenario: 1. Check Articles Number
    Given social cards is visibility
    Then scroll to article cards
    And I can see 4 cards


  Scenario Outline: 2'<n>' Check valid references of social cards

    Examples:
      | n | social name | reference                                   |
      | 1 | mail        | mailto:ask@wearecommunity.io                |
      | 2 | chat        | https://t.me/wearecommunityio               |
      | 3 | facebook    | https://www.facebook.com/wearecommunityio   |
      | 4 | instagram   | https://www.instagram.com/wearecommunity.io |