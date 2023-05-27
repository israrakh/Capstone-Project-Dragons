package tek.capstone.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class RetailAccountPaymentSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		waitTillPresence(factory.getAccountPage().addPaymentMethodLink);
		click(factory.getAccountPage().addPaymentMethodLink);
		logger.info("User successfully clicked on add payment method link");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getAccountPage().cardNumberInput, row.get("cardNumber"));
			sendText(factory.getAccountPage().nameOnCardInput, row.get("nameOnCard"));
			selectByVisibleText(factory.getAccountPage().expirationDateMonth, row.get("expirationMonth"));
			selectByVisibleText(factory.getAccountPage().expirationDateYear, row.get("expirationYear"));
			sendText(factory.getAccountPage().securityCodeInput, row.get("securityCode"));
		}
		logger.info("Informations were added successfully");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.getAccountPage().addYourCardButton);
		logger.info("Add Your Card button was successfully clicked");
	}

	@Then("a message should be displayed 'Payment Method added successfully'")
	public void aMessageShouldBeDisplayed() {
		waitTillPresence(factory.getAccountPage().paymentMethodSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.getAccountPage().paymentMethodSuccessMessage));
		logger.info("Payment method addedd successfully");
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.getAccountPage().masterCard);
		waitTillPresence(factory.getAccountPage().editPaymentButton);
		click(factory.getAccountPage().editPaymentButton);
		logger.info("User successfully clicked on Edit button");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			clearTextUsingSendKeys(factory.getAccountPage().cardNumberInput);
			clearTextUsingSendKeys(factory.getAccountPage().nameOnCardInput);
			clearTextUsingSendKeys(factory.getAccountPage().securityCodeInput);

			sendText(factory.getAccountPage().cardNumberInput, row.get("cardNumber"));
			sendText(factory.getAccountPage().nameOnCardInput, row.get("nameOnCard"));
			selectByVisibleText(factory.getAccountPage().expirationDateMonth, row.get("expirationMonth"));
			selectByVisibleText(factory.getAccountPage().expirationDateYear, row.get("expirationYear"));
			sendText(factory.getAccountPage().securityCodeInput, row.get("securityCode"));
		}
		logger.info("Informations were added successfully");
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.getAccountPage().updateYourCardButton);
		logger.info("User successfully clicked on Update Your Card button");
	}

	@Then("a message should be displayed 'Payment Method updated Successfully'")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		waitTillPresence(factory.getAccountPage().paymentMethodupdatedSuccessfullyMessage);
		Assert.assertEquals("Payment Method updated Successfully",
				factory.getAccountPage().paymentMethodupdatedSuccessfullyMessage.getText().trim());
		logger.info("Payment method updated successfully");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.getAccountPage().masterCard);
		click(factory.getAccountPage().removePaymentButton);
		logger.info("remove button was clicked successfully");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(isElementDisplayed(factory.getAccountPage().yourProfileText));
		logger.info("Payment details removed successfully");
	}
}
