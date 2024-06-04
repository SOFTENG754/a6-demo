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

    @FindBy(how = How.ID, using = "newProfilePicture")
    private WebElement newProfilePicture;

    @FindBy(how = How.ID, using = "changeProfilePictureBtn")
    private WebElement changeProfilePictureButton;

    @FindBy(how = How.ID, using = "newBannerPicture")
    private WebElement newBannerPicture;

    @FindBy(how = How.ID, using = "changeBannerPictureBtn")
    private WebElement changeBannerPictureButton;

    @FindBy(how = How.ID, using = "changeFlagsBtn")
    private WebElement changeFlagsButton;

    @FindBy(how = How.ID, using = "flagNZ")
    private WebElement flagNZ;

    @FindBy(how = How.ID, using = "flagAustralia")
    private WebElement flagAustralia;

    @FindBy(how = How.ID, using = "flagChina")
    private WebElement flagChina;

    @FindBy(how = How.ID, using = "flagUSA")
    private WebElement flagUSA;

    @FindBy(how = How.ID, using = "flagUK")
    private WebElement flagUK;



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

    public void uploadNewProfilePicture(String profilePicture) {
        this.newProfilePicture.sendKeys(profilePicture);
    }

    public void clickChangeProfilePictureButton() {
        this.changeProfilePictureButton.click();
    }

    public void uploadNewBannerPicture(String bannerPicture) {
        newBannerPicture.sendKeys(bannerPicture);
    }

    public void clickChangeBannerPictureButton() {
        this.changeBannerPictureButton.click();
    }

    public void selectFlags(String[] flags) {
        for (String flag : flags) {
            switch (flag) {
                case "New Zealand" -> {
                    if (!flagNZ.isSelected()) {
                        flagNZ.click();
                    }
                }
                case "Australia" -> {
                    if (!flagAustralia.isSelected()) {
                        flagAustralia.click();
                    }
                }
                case "China" -> {
                    if (!flagChina.isSelected()) {
                        flagChina.click();
                    }
                }
                case "USA" -> {
                    if (!flagUSA.isSelected()) {
                        flagUSA.click();
                    }
                }
                case "UK" -> {
                    if (!flagUK.isSelected()) {
                        flagUK.click();
                    }
                }
            }
        }
    }


    public void clickChangeFlagsButton() {
        this.changeFlagsButton.click();
    }
}
