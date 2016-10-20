Feature: Search Box
User Story:
As a user
I want to search product
So that I can easily find the product I want

        Scenario: Search existing item
                Given a search box
                When I search for an existing product
                Then I should see the product listed in the result

        Scenario: Search non-existing item
                Given a search box
                When I search for a non-existing product
                Then I should see the notice of nothing matched

        Scenario: Search nothing
                Given a search box
                When I search with empty search box
                Then I should still see some products displaying in the result
                
