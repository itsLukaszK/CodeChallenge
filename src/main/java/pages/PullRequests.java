package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.FilePage.getFileName;
import static pages.FilePage.getNewFileName;

public class PullRequests {
    private WebDriver driver;

    public PullRequests(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-selected-links^='repo_pulls']")
    WebElement pullRequestsButton;

    public void clickPullRequestsButton() {
        pullRequestsButton.click();
    }

    public boolean isPullRequestTitleCorrect() {
        String pullRequestTitle = "Rename " + getFileName() + " to " + getNewFileName();
        String xpath = "//a[contains(text(), '" + pullRequestTitle + "')]";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }
}
