Feature: ShoppingCart

User Story:
As a user
I want to use my shopping cart
So that I can get the information before checkout

        Scenario: Add an item and then check out
                Given that I am on iPhone 5 product page
                When I add an iPhone 5 and click check out
                Then the iPhone 5 is added to the shopping cart

        Scenario: Add an item and then continue shopping
                Given that I am on iPhone 5 product page
                When I add an iPhone 5 and continue shopping
                Then I will stay in current page and iPhone 5 is added to the shopping cart
                
        Scenario: Remove an item
                Given a shopping cart with only one Magic Mouse
                When I remove a Magic Mouse
                Then the Magic Mouse should not appear in shopping cart

        Scenario: Increase quantity of an item
                Given a shopping cart with an iPhone 5
                When I increase the quantity of iphone 5 from 1 to 2
                Then iPhone 5 quantity and total should be updated

                
                 


                
               




                
