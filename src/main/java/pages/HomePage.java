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

    private static final String HOME_PAGE = "https://github.com/";

    @FindBy(css = "a.text-bold[href='/login']")
    WebElement signInLink;

    public void goToHomePage() {
        driver.get(HOME_PAGE);
    }

    public void clickSignInLink() {
        signInLink.click();
    }


}
