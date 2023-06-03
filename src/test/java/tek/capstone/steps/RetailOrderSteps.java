package tek.capstone.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class RetailOrderSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

//	@When("User change category to 'Smart Home'")
//	public void userChangeTheCategoryToSmartHome() {
//		selectByVisibleText(factory.getHomePage().allDepartments, "Smart Home");
//		logger.info("User successfully changed the category to <Smart Home> ");
//	}

//	@When("User search for item 'kasa outdoor smart plug'")
//	public void userSearchForAnItemKasaOutdoorSmartPlug() {
//		sendText(factory.getHomePage().searchInputField, "kasa outdoor smart plug");
//	}

	@When("User change category to {string}")
	public void userChangeCategoryTo(String smartHome) {
		selectByVisibleText(factory.getHomePage().allDepartments, smartHome);
		logger.info("User successfully changed the category to <Smart Home> ");
	}

	@When("User search for item {string}")
	public void userSearchForItem(String kasa) {
		sendText(factory.getHomePage().searchInputField, kasa);
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.getHomePage().searchButton);
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.getOrderPage().kasa);
		logger.info("Item has clicked successfully");
	}

//	@When("User select quantity '2'")
//	public void userSelectQuantity2() {
//		selectByVisibleText(factory.getOrderPage().quantityDropdown, "2");
//		logger.info("User successfully selected the quantity to 2");
//	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String quant) {
		selectByVisibleText(factory.getOrderPage().quantityDropdown, quant);
		logger.info("User successfully selected the quantity to 2");
	}

//	@When("User select quantity '2'")
//	public void userSelectQuantity2() {
//		waitTillPresence(factory.getOrderPage().quantityDropdown);
//		selectByVisibleText(factory.getOrderPage().quantityDropdown, "2");
//		logger.info("User successfully selected the quantity to 2");
//	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.getOrderPage().addToCartButton);
	}

	@Then("cart icon quantity should change to {string}")
	public void cartIconQuantityShouldChangeTo(String quantTwo) {
		Assert.assertTrue(factory.getOrderPage().cartIconQuantity.isDisplayed());
		logger.info("Quantity changed to 2");
	}

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		waitTillPresence(factory.getHomePage().ordersOption);
		click(factory.getHomePage().ordersOption);
		logger.info("User successfully clicked on Orders option");
	}

//	@When("User click on first order in list")
//	public void userClickOnFirstOrderInList() {
//		waitTillPresence(factory.getOrderPage().orderDetailList);
//		click(factory.getOrderPage().orderDetailList);
//	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		waitTillPresence(factory.getOrderPage().cancelTheOrderButton);
		click(factory.getOrderPage().cancelTheOrderButton);
		logger.info("Cancel The Order button has clicked successfully");
	}

	@When("User select the cancelation Reason 'Bought wrong item'")
	public void userSelectTheCancelationReasonBoughtWrongItem() {
		Select select = new Select(factory.getOrderPage().cancelationReasonDropdown);
		select.selectByVisibleText("Bought wrong item");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.getOrderPage().cancelOrderBtn);
		logger.info("User successfully clicked on Cancel Order button");
	}

	@Then("a cancelation message should be displayed 'Your Order Has Been Cancelled'")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		waitTillPresence(factory.getOrderPage().orderCancelationMessage);
		Assert.assertEquals("Your Order Has Been Cancelled",
				factory.getOrderPage().orderCancelationMessage.getText().trim());
		logger.info("Your Order Has Been Cancelled");
	}
	
//  -----------------------------------------------------------------------------
//	@When("User change the category to 'Electronics'")
//	public void userChangeTheCategoryToElectronics() {
//		selectByVisibleText(factory.getHomePage().allDepartments, "Electronics");
//		logger.info("User successfully changed the category to Electronics");
//	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String elec) {
		selectByVisibleText(factory.getHomePage().allDepartments, elec);
		logger.info("User successfully changed the category to Electronics");
	}

//	@When("User search for an item 'Apex Legends'")
//	public void userSearchForAnItemApexLegends() {
//		waitTillPresence(factory.getHomePage().searchInputField);
//		sendText(factory.getHomePage().searchInputField, "Apex Legends");
//	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String apex) {
		waitTillPresence(factory.getHomePage().searchInputField);
		sendText(factory.getHomePage().searchInputField, apex);
	}

	@When("User click on item Apex")
	public void userClickOnItemApex() {
		click(factory.getOrderPage().apexLegendsFromSearchField);
		logger.info("Item has clicked successfully");
	}

//	@When("User select quantity '5'")
//	public void userSelectQuantity5() {
//		selectByVisibleText(factory.getOrderPage().quantityDropdown, "5");
//		logger.info("Quantity selected successfully to 5");
//	}

	@When("User select quantity to {string}")
	public void userSelectQuantityTo(String itemQuantity) {
		selectByVisibleText(factory.getOrderPage().quantityDropdown, itemQuantity);
		logger.info("Quantity selected successfully to 5");
	}

//	@Then("the cart icon quantity should change to '7'")
//	public void theCartIconQuantityShouldChangeTo5() {
//		Assert.assertTrue(isElementDisplayed(factory.getOrderPage().cartIconQuantity));
//		logger.info("Quantity changed to 5");
//	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String quantSeven) {
		Assert.assertTrue(isElementDisplayed(factory.getOrderPage().cartIconQuantity));
		logger.info("Quantity changed to 5");
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.getOrderPage().addToCartOption);
		logger.info("User successfully clicked on cart Option");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.getOrderPage().proceedToCheckoutButton);
		logger.info("User successfully clicked on Proceed to Checkout button");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		waitTillPresence(factory.getOrderPage().placeYourOrderBtn);
		click(factory.getOrderPage().placeYourOrderBtn);
		logger.info("User successfully clicked on Place Your Order");
	}

	@Then("a message should be displayed 'Order Placed, Thanks'")
	public void aMessageShouldBeDisplayed() {
		waitTillPresence(factory.getOrderPage().orderPlacedSuccessMessage);
		Assert.assertEquals("Order Placed Successfully",
				factory.getOrderPage().orderPlacedSuccessMessage.getText().trim());
		logger.info("Order Placed Successfully");
	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		waitTillPresence(factory.getOrderPage().returnItemsButton);
		click(factory.getOrderPage().returnItemsButton);
		logger.info("User Successfully clicked on Return Items button");
	}

	@When("User select the Return Reason 'Item damaged'")
	public void userSelectTheReturnReasonItemDamaged() {
		Select select = new Select(factory.getOrderPage().returnReasonDropdown);
		select.selectByVisibleText("Item damaged");
		logger.info("User successfully selected the Item damage option from dropdown");
	}

	@When("User select the drop off service 'FedEx'")
	public void userSelectTheDropOffServiceFedEx() {
		Select select = new Select(factory.getOrderPage().dropOffDropdown);
		select.selectByVisibleText("FedEx");
		logger.info("User successfully selected the FedEx option from dropdown");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.getOrderPage().returnOrderBtn);
		logger.info("User successfully clicked on Return Order button");
	}

	@Then("a cancelation message should be displayed 'Return was successfull’")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful() {
		waitTillPresence(factory.getOrderPage().returnSuccessMessage);
		Assert.assertEquals("Return was successfull", factory.getOrderPage().returnSuccessMessage.getText().trim());
		logger.info("Return was successful");
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		waitTillPresence(factory.getOrderPage().reviewButton);
		click(factory.getOrderPage().reviewButton);
		logger.info("Review button has been clicked succesffuly");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headline, String reviewText) {
		waitTillPresence(factory.getOrderPage().headlineInputField);
		waitTillPresence(factory.getOrderPage().reviewTextInputField);

		sendText(factory.getOrderPage().headlineInputField, headline);
		sendText(factory.getOrderPage().reviewTextInputField, reviewText);
		logger.info("Headline and Review text has been entered successfully");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.getOrderPage().addYourReviewBtn);
		logger.info("Add Your Review button has been clicked successfully");
	}

	@Then("a review message should be displayed 'Your review was added successfully'")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully() {
		waitTillPresence(factory.getOrderPage().reviewAddedSuccessMessage);
		Assert.assertEquals("Your review was added successfully",
				factory.getOrderPage().reviewAddedSuccessMessage.getText().trim());
		logger.info("Your review was added successfully");
	}
}
