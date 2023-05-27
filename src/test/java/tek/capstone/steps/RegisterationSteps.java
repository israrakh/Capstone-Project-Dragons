package tek.capstone.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class RegisterationSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.getSinginPage().createNewAccountBtn);
		logger.info("User successfully clicked on Create New Account button");
	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	
		for (Map<String, String> row : data) {
		
			sendText(factory.getSinginPage().nameFieldForRegister, row.get("name"));
			sendText(factory.getSinginPage().emailFieldForRegister, row.get("email"));
			sendText(factory.getSinginPage().passwordFieldForRegister, row.get("password"));
			sendText(factory.getSinginPage().confirmPasswordFieldForRegister, row.get("confirmPassword"));
		}
		logger.info("User entered name, email, password, confirm password successfully !");
	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.getSinginPage().signupButton);
		logger.info("User successfully clicked on signUp button");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(factory.getSinginPage().yourProfile.isDisplayed());
		logger.info("User successfully saw the Your Profile on account page");
	}
}
