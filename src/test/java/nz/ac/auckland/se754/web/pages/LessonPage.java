package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LessonPage {
    private WebDriver driver;
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

    public void clickDefinitionButton() {
        definitionButton.click();
    }

    public String getDefinition() {
        return definition.getText();
    }

    public void insertWord(String word) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('word').innerText = arguments[0];", word);
    }
}
