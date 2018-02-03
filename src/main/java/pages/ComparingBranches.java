package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparingBranches {
    private WebDriver driver;

    public ComparingBranches(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Create pull request']")
    WebElement createPullRequestButton;

    @FindBy(css = "div.merging-body h3.h4")
    WebElement branchConflictsInformation;

    public void clickCreatePullRequestButton(){
        createPullRequestButton.submit();
    }

    public WebElement getBranchConflictsInformation() {
        return branchConflictsInformation;
    }
}
