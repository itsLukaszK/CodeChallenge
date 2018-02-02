package cucumber_steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SignIn;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GithubCom {
    private WebDriver driver = new FirefoxDriver();
    private HomePage homePage = new HomePage(driver);
    private SignIn signIn = new SignIn(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);

    @Before
    public void beforeTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "The world's leading software development platform · GitHub");
    }

    @Given("^User is logged in$")
    public void userIsLoggedIn() {
        // TODO
        homePage.clickSignInLink();
        assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
        signIn.inputCorrectUsername();
        signIn.inputCorrectPassword();
        signIn.clickSignInButton();
        assertTrue(wait.until(ExpectedConditions.titleIs("GitHub")));
    }

    @When("^User creates a repository called 'Name'$")
    public void userCreatesARepositoryCalledName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The repository 'Name' exists$")
    public void theRepositoryNameExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
