# IS2545_DeliverableThree

At the beginning, when I download NetBeans project from github, all my tests skipped. I thought it was caused by incompatible Firefox driver. Then I tried to use ChromeDriver, SafariDriver and HtmlUnitDriver, but all my tests were still skipped. Then I randomly click test file "StepDefinition.java" and then run "TestRunner.java", I saw the error information indicating that there is something wrong with the gecko driver. After doing some research, I figured out that Mac and Windows are using different gecko driver. I get test running by changing the path of gecko driver and using gecko driver for Mac.

When I began to run my tests, some of my tests failed. I tried to figure out whether this is because I get the wrong element or the driver ran so fast that it didn't wait for the page to load. Then, I set the break point in StepDefinition.java and then debug test file to run my code step by step. After doing this, I knew the problem is that the driver didn't wait enough time. Then I use wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xxx))) to let the driver wait until the element appear and then do the next step. In some cases, there is no specific element appearing to define the waiting time, so I use Thread.sleep() to force the driver to wait. When the driver waits enough time, all my tests passed.

Note: I am using Mac to finish this deliverable, please comment "System.setProperty("webdriver.gecko.driver", "libs/geckodriver");" and uncomment "System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");" in all @Given methods to make the project run on Windows system.


1. User Story:
    As a user,
    I want to use my shopping cart,
    So that I can get the information before checkout.

(1) Given that I am on iPhone 5 product page,
    When I add an iPhone 5 and click check out,
    Then the iPhone 5 is added to the shopping cart and sub-total of shopping cart is correct.

(2) Given that I am on iPhone 5 product page,
    When I add an iPhone 5 and continue shopping,
    Then I will stay in current page and iPhone 5 is added to the shopping cart.

(3) Given a shopping cart with only one Magic Mouse,
    When I remove a Magic Mouse,
    Then the Magic Mouse should not appear in shopping cart.

(4) Given a shopping cart with an iPhone 5,
    When I increase the quantity of iphone 5 from 1 to 2,
    Then iPhone 5 quantity and total should be updated.

2. User Story:
    As a user,
    I want to log in,
    So that I can access my shopping account.

Scenarios:
(1) Given log in page of the e-commerce website,
    When I log in with correct username and password,
    Then I should see log out button.

(2)	Given log in page of the e-commerce website,
    When I log in with correct username and incorrect password,
    Then an error message should appear.

(3)	Given log in page of the e-commerce website,
    When I log in without username and password,
    Then a notice message should appear.

3. User Story:
    As a user,
    I want to search product,
    So that I can easily find the product I want.

Scenarios:
(1) Given a search box,
    When I search for an existing product,
    Then I should see the product listed in the result.

(2) Given a search box,
    When I search for a non-existing product,
    Then I should see the notice of nothing matched.

(3) Given a search box,
    When I search with empty search box,
    Then I should still see some products displaying in the result.
