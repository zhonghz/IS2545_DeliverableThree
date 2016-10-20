Feature: Log In

User Story:
As a user
I want to log in
So that I can access my shopping account

        Scenario: Correct username and password
                Given log in page of the e-commerce website
                When I log in with correct username and password
                Then I should see log out button

        Scenario: Correct username and incorrect password
		Given log in page of the e-commerce website
                When I log in with correct username and incorrect password
                Then an error message should appear

        Scenario: Correct username and empty password
		Given log in page of the e-commerce website
                When I log in without username and password
                Then a notice message should appear

                
