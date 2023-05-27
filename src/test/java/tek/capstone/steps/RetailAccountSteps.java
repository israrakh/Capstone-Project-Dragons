package tek.capstone.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class RetailAccountSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		waitTillPresence(factory.getHomePage().accountOption);
		click(factory.getHomePage().accountOption);
		logger.info("User successfully clicked on Account option.");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		clearTextUsingSendKeys(factory.getAccountPage().accountNameField);
		sendText(factory.getAccountPage().accountNameField, name);
		clearTextUsingSendKeys(factory.getAccountPage().accountPhoneField);
		sendText(factory.getAccountPage().accountPhoneField, phone);

		logger.info("User successfully entered new name and phone number.");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.getAccountPage().updateButton);
		logger.info("User successfully clicked on Update button.");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.getAccountPage().messageUpdatedSuccessText);
		Assert.assertTrue(isElementDisplayed(factory.getAccountPage().messageUpdatedSuccessText));
		logger.info("Profile informations updated successfully");
	}

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.getAccountPage().AddAddressOption);
		logger.info("Add Address option was clicked successfully");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> info = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : info) {
			selectByVisibleText(factory.getAccountPage().countryDropdown, row.get("country"));
			sendText(factory.getAccountPage().fullNameInput, row.get("fullName"));
			sendText(factory.getAccountPage().phoneNumInput, row.get("phoneNumber"));
			sendText(factory.getAccountPage().streetInput, row.get("streetAddress"));
			sendText(factory.getAccountPage().apartmentInput, row.get("apt"));
			sendText(factory.getAccountPage().cityInput, row.get("city"));
			selectByVisibleText(factory.getAccountPage().stateDropdown, row.get("state"));
			sendText(factory.getAccountPage().zipCodeInput, row.get("zipCode"));
		}
		logger.info("Informations were added successfully");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.getAccountPage().addYourAddressButton);
		logger.info("Add Your Address button was clicked successfully");
		
	}
	
	@Then("a message should be displayed 'Address Added Successfully'")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
		waitTillPresence(factory.getAccountPage().addressAddedSuccessfulltText);
		Assert.assertEquals("Address Added Successfully", factory.getAccountPage().addressAddedSuccessfulltText.getText().trim());
		logger.info("Address Added Successfully");
	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.getAccountPage().editBtnFromAddress);
		logger.info("Edit button was clicked successfully");
		clearTextUsingSendKeys(factory.getAccountPage().countryDropdown);
		clearTextUsingSendKeys(factory.getAccountPage().fullNameInput);
		clearTextUsingSendKeys(factory.getAccountPage().phoneNumInput);
		clearTextUsingSendKeys(factory.getAccountPage().streetInput);
		clearTextUsingSendKeys(factory.getAccountPage().apartmentInput);
		clearTextUsingSendKeys(factory.getAccountPage().cityInput);
		clearTextUsingSendKeys(factory.getAccountPage().stateDropdown);
		clearTextUsingSendKeys(factory.getAccountPage().zipCodeInput);
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		waitTillPresence(factory.getAccountPage().updateYourAddressBtn);
		click(factory.getAccountPage().updateYourAddressBtn);
		logger.info("Update Your Address Button was clicked successfully");
	}

	@Then("a message should be displayed 'Address Updated Successfully'")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
	    waitTillPresence(factory.getAccountPage().addressUpdatedSuccessfullyMessage);
	    Assert.assertEquals("Address Updated Successfully", factory.getAccountPage().addressUpdatedSuccessfullyMessage.getText().trim());
	    logger.info("Address Updated Successfully");
	}
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		waitTillPresence(factory.getAccountPage().removeAddressButton);
		click(factory.getAccountPage().removeAddressButton);
		logger.info("Remove button from Address section was clicked successfully");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		logger.info("Address details have removed successfully");
	}
}
