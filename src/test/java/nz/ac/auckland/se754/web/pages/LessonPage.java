package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LessonPage {
    public LessonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".definitionButton")
    private WebElement definitionButton;

    @FindBy(how = How.CSS, using = ".definition")
    private WebElement definition;

    public void clickDefinitionButton() {
        definitionButton.click();
    }

    public String getDefinition() {
        return definition.getText();
    }
}
