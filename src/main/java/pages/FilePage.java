package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage {
    private WebDriver driver;

    public FilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.btn-octicon[aria-label='Edit this file']")
    WebElement editThisFileButton;

    public void clickEditThisFileButton(){
        editThisFileButton.click();
    }
}
