package tek.capstone.pages;

import tek.capstone.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private RetailSignInPage signinPage;
	private RetailHomePage homePage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;

	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signinPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}

	public RetailSignInPage getSinginPage() {
		return this.signinPage;
	}

	public RetailHomePage getHomePage() {
		return this.homePage;
	}

	public RetailAccountPage getAccountPage() {
		return this.accountPage;
	}

	public RetailOrderPage getOrderPage() {
		return this.orderPage;
	}

	// Syntax for @FindBy annotation:
	// @FindBy(locatorType= "Locator Value") accessModifier WebElement ElementName;
}
