@AceLaptopIOS
	Feature: Purchase Ace Laptop in IOS device
		Scenario: Select and purchase a Laptop in IOS device
			Given I am on website in IOS device "./testscriptrepository/testdata/TestData.xls"
			When I select Laptop from Electronic Category in IOS device
			And Add Laptop to cart and Checkout in IOS device
			And Provide billing details and shipping address for Laptop checkout in IOS device
			Then I should be on the purchase confirmation page in IOS device