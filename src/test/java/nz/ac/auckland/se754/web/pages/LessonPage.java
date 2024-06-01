package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LessonPage {
    private final WebDriver driver;
    public LessonPage(WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "word")
    private WebElement word;

    @FindBy(how = How.ID, using = "definitionButton")
    private WebElement definitionButton;

    @FindBy(how = How.ID, using = "definition")
    private WebElement definition;

    @FindBy(how = How.ID, using = "exampleButton")
    private WebElement exampleButton;

    @FindBy(how = How.ID, using = "example")
    private WebElement example;

    @FindBy(how = How.ID, using = "synonymsAndAntonymsButton")
    private WebElement synonymsAndAntonymsButton;

    @FindBy(how = How.ID, using = "synonymsAndAntonyms")
    private WebElement synonymsAndAntonyms;

    @FindBy(how = How.ID, using = "showImageButton")
    private WebElement showImageButton;

    @FindBy(how = How.ID, using = "image")
    private WebElement image;

    @FindBy(how = How.ID, using = "pronounceButton")
    private WebElement pronounceButton;

    @FindBy(how = How.ID, using = "pronunciation")
    private WebElement pronunciation;

    public void clickDefinitionButton() {
        definitionButton.click();
    }

    public String getDefinition() {
        return definition.getText();
    }

    public void clickExampleButton() {
        exampleButton.click();
    }

    public String getExample() {
        return example.getText();
    }

    public void clickSynonymsAndAntonymsButton() {
        synonymsAndAntonymsButton.click();
    }

    public ArrayList<String> getSynonymsAndAntonyms() {
        String synonymsAndAntonymsText = synonymsAndAntonyms.getText();
        List<String> synonymsAndAntonymsList = Arrays.asList(synonymsAndAntonymsText.replace("\"", "").replace("[","").replace("]","").split(","));
        return new ArrayList<>(synonymsAndAntonymsList);
    }

    public void clickShowImageButton() {
        showImageButton.click();
    }

    public String getImageUrl() {
        return image.getAttribute("src");
    }

    public void clickPronounceButton() {
        pronounceButton.click();
    }

    public String getPronounceAudioUrl() {
        return pronunciation.getAttribute("src");
    }

    public void insertWord(String word) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('word').innerText = arguments[0];", word);
    }

    public String getAlertText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2); // 2 seconds timeout
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }
}
