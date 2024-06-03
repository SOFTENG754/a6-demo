package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public ProfilePage(WebDriver driver) {
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
        return this.alertMessage.getText();
    }
}
