package tek.capstone.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.pages.POMFactory;
import tek.capstone.utilities.CommonUtilities;

public class RetailHomeSteps extends CommonUtilities {

	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.getHomePage().sidebarAllButton);
		logger.info("All departments section has clicked successfully");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {

		List<List<String>> options = dataTable.asLists(String.class);

		for (List<String> row : options) {
			isElementDisplayed(factory.getHomePage().electronicsOption);
			isElementDisplayed(factory.getHomePage().computersOption);
			isElementDisplayed(factory.getHomePage().smartHomeOption);
			isElementDisplayed(factory.getHomePage().sportsOption);
			isElementDisplayed(factory.getHomePage().automativeOption);
			System.out.println(row);
		}
		logger.info("Options: Electronics, Computers, Smart Home, Sports, and Automative are present.");
	}

	String department;

	@When("User on {string}")
	public String userOn(String department) {

		switch (department) {
		case "Electronics":
			Assert.assertTrue(isElementDisplayed(factory.getHomePage().electronicsOption));
			logger.info("User is on Electronics section");
			break;
		case "Computers":
			Assert.assertTrue(isElementDisplayed(factory.getHomePage().computersOption));
			logger.info("User is on Computers section");
			break;
		case "Smart Home":
			Assert.assertTrue(isElementDisplayed(factory.getHomePage().smartHomeOption));
			logger.info("User is on Smart Home section");
			break;
		case "Sports":
			Assert.assertTrue(isElementDisplayed(factory.getHomePage().sportsOption));
			logger.info("User is on Sports section");
			break;
		case "Automotive":
			Assert.assertTrue(isElementDisplayed(factory.getHomePage().automativeOption));
			logger.info("User is on Automative section");
			break;
		default:
			throw new IllegalArgumentException("Invalid department name: " + this.department);
		}
		return this.department = department;
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<Map<String, String>> departmentSections = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> option : departmentSections) {
			String optionOne = option.get("optioneOne");
			String optionTwo = option.get("optioneTwo");

			switch (this.department) {
			case "Electronics":
				click(factory.getHomePage().electronicsOption);
				String tvAndVideo = getText(factory.getHomePage().tvAndVideo);
				String videoGames = getText(factory.getHomePage().videoGames);
				Assert.assertEquals(tvAndVideo, optionOne);
				Assert.assertEquals(videoGames, optionTwo);
				logger.info(
						optionOne + " and " + optionTwo + " options are present in " + this.department + " department");
				break;
			case "Computers":
				click(factory.getHomePage().computersOption);
				String accessories = getText(factory.getHomePage().accessories);
				String networking = getText(factory.getHomePage().networking);
				Assert.assertEquals(accessories, optionOne);
				Assert.assertEquals(networking, optionTwo);
				logger.info(
						optionOne + " and " + optionTwo + " options are present in " + this.department + " department");
				break;
			case "Smart Home":
				click(factory.getHomePage().smartHomeOption);
				String smartHomeLightning = getText(factory.getHomePage().smartHomeLightning);
				String plugsAndOutlets = getText(factory.getHomePage().plugsAndOutlets);
				Assert.assertEquals(smartHomeLightning, optionOne);
				Assert.assertEquals(plugsAndOutlets, optionTwo);
				logger.info(
						optionOne + " and " + optionTwo + " options are present in " + this.department + " department");
				break;
			case "Sports":
				click(factory.getHomePage().sportsOption);
				String athleticClothing = getText(factory.getHomePage().athleticClothing);
				String exerciseFitness = getText(factory.getHomePage().exerciseAndFitness);
				Assert.assertEquals(athleticClothing, optionOne);
				Assert.assertEquals(exerciseFitness, optionTwo);
				logger.info(
						optionOne + " and " + optionTwo + " options are present in " + this.department + " department");
				break;
			case "Automotive":
				click(factory.getHomePage().automativeOption);
				String automativePartsAccessories = getText(factory.getHomePage().automativePartsAccessories);
				String motorCyclePowersports = getText(factory.getHomePage().motorCyclePowersports);
				Assert.assertEquals(automativePartsAccessories, optionOne);
				Assert.assertEquals(motorCyclePowersports, optionTwo);
				logger.info(
						optionOne + " and " + optionTwo + " options are present in " + this.department + " department");
				break;
			default:
				throw new IllegalArgumentException("Invalid department name: " + this.department);
			}
		}
	}

}
