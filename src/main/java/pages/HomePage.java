package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "summary.HeaderNavlink[aria-label='Create new…']")
    WebElement createNewButton;

    @FindBy(css = "a.dropdown-item[href='/new']")
    WebElement newRepositoryDropdownItem;

    public void selectNewRepositoryDropdownItem(){
        createNewButton.click();
        newRepositoryDropdownItem.click();
    }
}
