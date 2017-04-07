@iPad
Feature: Purchase iPad

	Scenario: Select and purchase an iPad
		Given I am on the online store website "./testscriptrepository/testdata/TestData.xls"
		When I select iPad from Product Category
		And Add iPad to cart and Checkout
		And Provide billing details and shipping address for iPad checkout
		Then I should be on the Purchase iPad confirmation page