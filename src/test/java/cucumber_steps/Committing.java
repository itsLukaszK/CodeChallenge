package cucumber_steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EditingFile;
import pages.FilePage;
import pages.Repository;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertTrue;

public class Committing {
    Repository repository = new Repository(driver);
    FilePage filePage = new FilePage(driver);
    EditingFile editingFile = new EditingFile(driver);

    @When("^User changes the name of the '(.*)' file to '(.*)' and chooses '(.*)'$")
    public void userChangesTheNameOfTheFileNameFileToNewFileNameAndChoosesCommitType(String fileName, String newFileName, String commitType) {
        repository.openAFile(fileName);
        filePage.clickEditThisFileButton();
        editingFile.changeTheNameOfTheFileTo(newFileName);
        switch (commitType) {
            case "Commit directly to the master branch.":
                editingFile.clickCommitChangesButton();
                break;
            case "Create a new branch for this commit and start a pull request.":
                editingFile.choosePullRequest();
                editingFile.clickProposeFileChangeButton();
                break;
            default:
                assertTrue(false, "Wrong commit type provided. Please choose 'Commit directly to the master branch.' or 'Create a new branch for this commit and start a pull request.'.");
                break;
        }
    }
}
