Feature: Home Page Header

  Scenario: User sees the correct header text
    Given the user navigates to the home page
    Then the user should see the header text "Example Domain"