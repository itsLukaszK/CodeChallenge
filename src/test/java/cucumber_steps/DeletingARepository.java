package cucumber_steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.Options;
import pages.Repository;

import static cucumber_steps.BeforeAfter.createANewRepository;
import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CreateANewRepository.getRepositoryName;
import static pages.SignIn.getUSERNAME;

public class DeletingARepository {
    Repository repository = new Repository(driver);
    Options options = new Options(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);
    HomePage homePage = new HomePage(driver);

    @When("^User deletes the created repository$")
    public void userDeletesTheCreatedRepository() {
        assertEquals(driver.getTitle(), getUSERNAME() + "/" + getRepositoryName());
        repository.clickSettingsLink();
        assertTrue(wait.until(ExpectedConditions.titleIs("Options")));
        options.clickDeleteThisRepositoryButton();
        options.inputRepositoryName(getRepositoryName());
        options.confirmDeletingTheRepository();
        //TODO
    }

    @Then("^The repository has been deleted$")
    public void theRepositoryHasBeenDeleted() {
        options.provideSudoPasswordIfRequired();
        assertTrue(homePage.isDeletingConfirmationDisplayed());
    }
}
