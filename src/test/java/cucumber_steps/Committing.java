package cucumber_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EditingFile;
import pages.FilePage;
import pages.Repository;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertTrue;
import static pages.FilePage.getFileName;
import static pages.FilePage.getNewFileName;

public class Committing {
    private Repository repository = new Repository(driver);
    private FilePage filePage = new FilePage(driver);
    private EditingFile editingFile = new EditingFile(driver);

    @When("^User changes the name of the '(.*)' file to '(.*)' and chooses '(.*)'$")
    public void userChangesTheNameOfTheFileNameFileToNewFileNameAndChoosesCommitType(String fileName, String newFileName, String commitType) throws InterruptedException {
        filePage.setFileName(fileName);
        filePage.setNewFileName(newFileName);
        repository.openAFile(getFileName());
        filePage.clickEditThisFileButton();
        editingFile.changeTheNameOfTheFileTo(getNewFileName());
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

    @Then("^The changes have been committed$")
    public void theChangesHaveBeenCommitted() {
        assertTrue(filePage.isCommitTitleCorrect());
    }
}
