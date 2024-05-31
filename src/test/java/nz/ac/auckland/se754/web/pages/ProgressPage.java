package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProgressPage {

    public ProgressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "my-progress")
    private WebElement myProgress;

    @FindBy(how = How.ID, using = "username-input")
    private WebElement usernameInput;

    @FindBy(how = How.ID, using = "submit-button")
    private WebElement submitButton;

    @FindBy(how = How.ID, using = "other-user-progress")
    private WebElement otherUserProgress;

    @FindBy(how = How.ID, using = "error")
    private WebElement error;

    public String getMyProgress() {
        return myProgress.getText();
    }

    public void search(String username) {
        usernameInput.sendKeys(username);
        submitButton.click();
    }

    public String getOtherUserProgress(){
        return otherUserProgress.getText();
    }

    public String getError() {
        return error.getText();
    }
}
