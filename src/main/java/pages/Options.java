package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Options {
    private WebDriver driver;

    public Options(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
    WebElement deleteThisRepositoryButton;

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]//following::input[@class='form-control input-block']")
    WebElement repositoryNameInput;

    @FindBy(xpath = "//button[contains(text(),'I understand the consequences, delete this repository')]")
    WebElement deleteThisRepositoryConfirmationButton;

    public void clickDeleteThisRepositoryButton(){
        deleteThisRepositoryButton.click();
    }

    public void inputRepositoryName(String name){
        repositoryNameInput.clear();
        repositoryNameInput.sendKeys(name);
    }

    public void confirmDeletingTheRepository(){
        deleteThisRepositoryConfirmationButton.submit();
    }
}
