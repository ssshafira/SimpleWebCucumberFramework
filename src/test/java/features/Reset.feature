@reset
Feature: Reset User Input
  Verify if user is able to reset the entered username and password

  Scenario Outline: Reset the entered username and password
    Given I open browser Chrome
    When I navigate to url "<url>"
    And I delay 3 Second
    And I set text "<username>" in UserID Text Box
    And I delay 3 Second
    And I set text "<password>" in Password Text Box
    And I delay 3 Second
    And I click Reset button
    Then UserID Text Box is empty
    And Password Text Box is empty
    And I close browser
    Examples:
			| url | username | password | 
			| https://www.demo.guru99.com/v4/ | usertesting | P@ssw0rd | 
