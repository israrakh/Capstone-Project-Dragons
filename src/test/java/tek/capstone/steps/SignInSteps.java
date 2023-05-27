package tek.capstone.steps;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class SignInSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);

		Assert.assertTrue(isElementDisplayed(factory.getHomePage().tekSchoolLogo));
		logger.info("User is on retail website");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.getHomePage().signinOption);
		logger.info("User successfully clicked on signin option.");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.getSinginPage().emailInputField, email);
		logger.info(email + " was entered successfully !");
		sendText(factory.getSinginPage().passwordInputField, password);
		logger.info(password + " was entered successfully !");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.getSinginPage().loginButton);
		logger.info("User successfully clicked on login button.");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		waitTillPresence(factory.getHomePage().accountOption);
		Assert.assertTrue(isElementDisplayed(factory.getHomePage().accountOption));
		Assert.assertTrue(isElementDisplayed(factory.getHomePage().ordersOption));
		Assert.assertTrue(isElementDisplayed(factory.getHomePage().logOutOption));
		logger.info("User successfully logged in into account");
	}
}
