package cucumber_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComparingBranches;
import pages.PullRequests;

import java.util.concurrent.TimeUnit;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertTrue;

public class CreatingPullRequest {
    private ComparingBranches comparingBranches = new ComparingBranches(driver);
    private PullRequests pullRequests = new PullRequests(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);

    @When("^User creates pull request$")
    public void userCreatesPullRequest() {
        comparingBranches.clickCreatePullRequestButton();
    }

    @Then("^The pull request has been created$")
    public void thePullRequestHasBeenCreated() {
        pullRequests.clickPullRequestsButton();
        assertTrue(pullRequests.isPullRequestTitleCorrect());
    }
}
