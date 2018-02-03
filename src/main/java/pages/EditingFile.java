package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingFile {
    private WebDriver driver;

    public EditingFile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.form-control.js-blob-filename")
    WebElement fileNameInput;

    @FindBy(xpath = "//button[contains(text(), 'Commit changes')]")
    WebElement commitChangesButton;

    @FindBy(css = "input[value='quick-pull']")
    WebElement choosePullRequestInput;

    @FindBy(xpath = "//button[text()='Propose file change']")
    WebElement proposeFileChangeButton;

    public void changeTheNameOfTheFileTo(String newFileName){
        fileNameInput.clear();
        fileNameInput.sendKeys(newFileName);
    }

    public void clickCommitChangesButton(){
        commitChangesButton.submit();
    }

    public void choosePullRequest(){
        choosePullRequestInput.click();
    }

    public void clickProposeFileChangeButton(){
        proposeFileChangeButton.submit();
    }

}
