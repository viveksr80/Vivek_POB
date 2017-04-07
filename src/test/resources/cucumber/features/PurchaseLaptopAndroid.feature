@AceLaptopAndroid
	Feature: Purchase Ace Laptop in Android device
      Scenario: Select and purchase a Laptop in Android device
        Given I am on website in Android device "./testscriptrepository/testdata/TestData.xls"
        When I select Laptop from Electronic Category in Android device
        And Add Laptop to cart and Checkout in Android device
        And Provide billing details and shipping address for Laptop checkout in Android device
        Then I should be on the purchase confirmation page in Android device