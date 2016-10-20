Feature: Search Box
User Story:
As a user
I want to search product
So that I can easily find the product I want

        Scenario: Search existing item
                Given home page of the e-commerce website
                When I search magic mouse
                Then I should see the product listed in the result

        Scenario: Search non-existing item
                Given home page of the e-commerce website
                When I search iphone7
                Then I should see the notice of nothing matched

        Scenario: Search nothing
                Given home page of the e-commerce website
                When I search with empty search box
                Then I should still see some products displaying in the result
                
