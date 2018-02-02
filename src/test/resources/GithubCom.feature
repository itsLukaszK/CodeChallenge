Feature: Github.com

  Scenario: Creating a repository
    Given User is logged in
    When User creates a repository called 'Name'
    Then The repository 'Name' exists