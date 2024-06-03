package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "newUsername")
    private WebElement newUsername;

    @FindBy(how = How.ID, using = "changeUsernameBtn")
    private WebElement changeUsernameButton;

    @FindBy(how = How.ID, using = "alertMessage")
    private WebElement alertMessage;

    public void enterNewUsername(String newUsername) {
        this.newUsername.sendKeys(newUsername);
    }

    public void clickChangeUsernameButton() {
        this.changeUsernameButton.click();
    }

    public String getAlertText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }

    public void clickChangeProfilePictureButton() {
    }
}
