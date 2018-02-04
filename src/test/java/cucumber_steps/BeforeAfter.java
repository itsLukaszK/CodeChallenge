package cucumber_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CreateANewRepository.getRepositoryName;
import static pages.MainPage.getMainPage;
import static pages.SignIn.getUSERNAME;

public class BeforeAfter {
    public static WebDriver driver = new FirefoxDriver();
    public static CreateANewRepository createANewRepository = new CreateANewRepository(driver);
    private MainPage mainPage = new MainPage(driver);
    private Repository repository = new Repository(driver);
    Options options = new Options(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);
    private HomePage homePage = new HomePage(driver);

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.goToMainPage();
        assertEquals(driver.getTitle(), "The world's leading software development platform · GitHub");
    }

    @After("@DeleteAfter")
    public void afterTest() {
        driver.get(getMainPage() + getUSERNAME() + "/" + getRepositoryName());
        //assertTrue(wait.until(ExpectedConditions.titleIs(getUSERNAME() + "/" + getRepositoryName())));
        //assertEquals(driver.getTitle(), getUSERNAME() + "/" + getRepositoryName());
        repository.clickSettingsLink();
        assertTrue(wait.until(ExpectedConditions.titleIs("Options")));
        options.clickDeleteThisRepositoryButton();
        options.inputRepositoryName(getRepositoryName());
        options.confirmDeletingTheRepository();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getUserMenuButton()));
        mainPage.goToMainPage();
        homePage.signOut();
    }

    @After("@signOutAfter")
    public void quitAfterTest() {
        mainPage.goToMainPage();
        homePage.signOut();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
