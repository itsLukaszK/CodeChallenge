package cucumber_steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Options;
import pages.Repository;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CreateANewRepository.getRepositoryName;
import static pages.SignIn.getUSERNAME;

public class DeletingARepository {
    Repository repository = new Repository(driver);
    Options options = new Options(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);

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
}
