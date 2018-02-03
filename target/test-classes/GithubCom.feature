Feature: Github.com

  Scenario: Creating a repository
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    # ^ Max name length = 100
    Then The repository 'Name' exists

  Scenario: Committing
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User changes the name of the 'README.md' file to 'READMEupdate.md' and chooses 'Commit directly to the master branch.'
    #Then

  Scenario: Creating Pull Request
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User changes the name of the 'README.md' file to 'READMEupdate.md' and chooses 'Create a new branch for this commit and start a pull request.'
    #Then

  Scenario: Deleting a repository
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User deletes the created repository
    #Then The repository 'Name' does not exist
